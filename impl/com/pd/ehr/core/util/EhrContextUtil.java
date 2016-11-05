package com.pd.ehr.core.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EhrContextUtil
{
    private static ApplicationContext getSingleCtx()
    {
        return SingletonCtx.ctx;
    }
    
    public static Object getBean(String beanName, Class<?> class1)
    {
        return getSingleCtx().getBean(beanName);
    }
    
    public static class SingletonCtx
    {
        private static ApplicationContext ctx =
            new ClassPathXmlApplicationContext(new String[] {"ApplicationContext.xml"});
        
    }
}
