package com.pd.it.common.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.VO;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil
{
    private static Configuration cfg = new Configuration();
    
    public static String cal(String templateValue, VO vo)
    {
        StringReader sr = new StringReader(templateValue);
        Template template;
        try
        {
            template = new Template("", sr);
            return cal(template, vo);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
    
    public static String cal(Template template, VO vo)
    {
        if (template == null)
        {
            return null;
        }
        StringWriter sw = new StringWriter();
        try
        {
            template.process(vo, sw);
        }
        catch (TemplateException | IOException e)
        {
            e.printStackTrace();
        }
        return sw.toString();
    }
    
    public static String cal(Template template, Object vo)
    {
        if (template == null)
        {
            return null;
        }
        StringWriter sw = new StringWriter();
        try
        {
            template.process(vo, sw);
        }
        catch (TemplateException | IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sw.toString();
    }
}
