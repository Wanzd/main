package com.pd.it.util.string;

import java.io.IOException;
import java.io.StringWriter;

import com.pd.it.common.vo.KV;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil
{
    
    public static String cal(Template template, KV vo)
    {
        
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
