package com.pd.it.common.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.xerces.parsers.CachingParserPool.ShadowedGrammarPool;

import com.pd.it.common.util.Db;
import com.pd.it.common.util.LogUtil;
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
            LogUtil.function();
            cfg = new Configuration();
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            
            VO lookupFilterVO = VOFactory.build("typeId", "dao");
            List<VO> raItem = Db.raDao(lookupFilterVO);
            
            StringTemplateLoader loader = new StringTemplateLoader();
            for (VO eachItem : raItem)
            {
                String key = null;
                if (eachItem.str("demension").length() > 0)
                {
                    key = String
                        .format("%s$%s.%s", eachItem.str("module"), eachItem.str("demension"), eachItem.str("action"));
                }
                else
                {
                    key = String.format("%s.%s", eachItem.str("module"), eachItem.str("action"));
                }
                LogUtil.log(String.format("DaoKey:%s", key));
                loader.putTemplate(key, eachItem.str("value"));
                loader.putTemplate(key + "_jsonData", eachItem.str("jsonData"));
            }
            cfg.setTemplateLoader(loader);
        }
    }
    
    public static VO cfg(String key, Object vo)
    {
        
        VO rsVO = new VO();
        Template template = getTemplate(key);
        String sql = FreeMarkerUtil.cal(template, vo);
        rsVO.put("sql", sql);
        
        Template templateJsonData = getTemplate$jsonData(key);
        String sqlJsonDaota = FreeMarkerUtil.cal(templateJsonData, vo);
        rsVO.put("schema", sqlJsonDaota);
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
    
    private static Template getTemplate$jsonData(String key)
    {
        Template template = null;
        try
        {
            template = cfg.getTemplate(key + "_jsonData");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return template;
    }
    
}
