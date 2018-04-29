package com.pd.db.sqlprovider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.pd.it.common.util.AI;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.VO;
import com.pd.it.util.string.FreeMarkerUtil;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class CommonSqlProvider implements ISqlProvider
{
    private static Configuration cfg = new Configuration();
    
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
            StringTemplateLoader loader = new StringTemplateLoader();
            loader.putTemplate("user.r", "select * from user_base_t where id=1");
            loader.putTemplate("lookup.r", "select * from lookup_t where type_id=${typeId} and id=${id}");
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
            template = cfg.getTemplate(path.v("module")+"."+path.v("action"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return template;
    }
    
    @Override
    public String cal(KV path, VO vo)
    {
        return null;
    }
}
