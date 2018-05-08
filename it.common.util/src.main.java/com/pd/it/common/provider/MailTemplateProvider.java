package com.pd.it.common.provider;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pd.it.common.util.AI;
import com.pd.it.common.util.LookupUtil;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.MailVO;
import com.pd.it.common.vo.VO;
import com.pd.it.common.vo.VOFactory;
import com.pd.it.util.string.FreeMarkerUtil;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class MailTemplateProvider
{
    private static Configuration cfg = new Configuration();
    
    static
    {
        refresh();
    }
    
    public static void refresh()
    {
        synchronized (cfg)
        {
            cfg = new Configuration();
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            
            List<VO> raItem = LookupUtil.raTemplate();
            
            StringTemplateLoader loader = new StringTemplateLoader();
            for (VO eachItem : raItem)
            {
                loader.putTemplate(eachItem.str("id"), eachItem.str("value"));
            }
            cfg.setTemplateLoader(loader);
        }
    }
    
    public static MailVO cfg(VO path, VO vo)
    {
        
        Template template = getTemplate(path.str("id"));
        VO vo1 = new VO();
        vo1.put("id", "id1");
        vo1.put("name", "name1");
        vo1.put("detail", "detail1");
        VO vo2 = new VO();
        vo2.put("id", "id2");
        vo2.put("name", "name2");
        vo2.put("detail", "detail2");
        vo.put("contentList", AI.list(vo1, vo2));
        String content = FreeMarkerUtil.cal(template, vo);
        
        MailVO rsVO = new MailVO();
        rsVO.setContent(content);
        rsVO.setTitle(FreeMarkerUtil.cal(path.str("title"), vo));
        rsVO.setTo(path.str("to"));
        rsVO.setFrom(vo.str("from"));
        rsVO.setCc(path.str("cc"));
        rsVO.setBcc(path.str("bcc"));
        return rsVO;
    }
    
    private static Template getTemplate(String key)
    {
        Template template = null;
        try
        {
            template = cfg.getTemplate(key);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return template;
    }
    
}
