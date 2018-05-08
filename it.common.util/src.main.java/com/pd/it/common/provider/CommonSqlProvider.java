package com.pd.it.common.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.pd.it.common.util.LookupUtil;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.VO;
import com.pd.it.common.vo.VOFactory;
import com.pd.it.util.string.FreeMarkerUtil;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class CommonSqlProvider
{
    private static Configuration cfg = new Configuration();
    
    private static SqlSession sqlSession;
    
    private static Map<String, KV> sqlTemplateMap = new HashMap<String, KV>();
    
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
            
            VO lookupFilterVO = VOFactory.build("typeId", "daoKV");
            List<VO> raItem = LookupUtil.raItem(lookupFilterVO);
            
            StringTemplateLoader loader = new StringTemplateLoader();
            for (VO eachItem : raItem)
            {
                loader.putTemplate(eachItem.str("id"), eachItem.str("value"));
            }
            cfg.setTemplateLoader(loader);
        }
    }
    
    public static VO cfg(KV path, VO vo)
    {
        
        VO rsVO = new VO();
        KV vo2Kv = new KV(vo);
        Template template = getTemplate(path);
        String sql = FreeMarkerUtil.cal(template, vo2Kv);
        rsVO.put("sql", sql);
        return rsVO;
    }
    
    private static Template getTemplate(KV path)
    {
        Template template = null;
        try
        {
            template = cfg.getTemplate(path.v("module") + "." + path.v("action"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return template;
    }
    
}
