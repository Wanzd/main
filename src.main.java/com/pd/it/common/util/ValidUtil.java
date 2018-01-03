package com.pd.it.common.util;

import com.pd.it.common.itf.IValidRule;

public class ValidUtil
{
    public static boolean eq(Object o1, Object o2)
    {
        if (o1 == null && o2 == null)
        {
            return true;
        }
        if ((o1 == null && o2 != null) || (o1 != null && o2 == null))
        {
            return false;
        }
        if (o1 == o2)
        {
            return true;
        }
        if (o1.equals(o2))
        {
            return true;
        }
        return false;
    }
    
    public static <In> boolean valid(In in, Class<In> inClass, String beansStr)
    {
        String[] beans = beansStr.split(",");
        for (String eachBeanName : beans)
        {
            boolean capFlag = ValidUtil.eq("!", eachBeanName.substring(0, 1));
            if (capFlag)
            {
                eachBeanName = eachBeanName.substring(1);
            }
            IValidRule<In> validRule = BeanUtil.<In> getValidRule(inClass, eachBeanName);
            if (validRule == null)
            {
                return false;
            }
            boolean curFlag = validRule.valid(in);
            if (!curFlag ^ capFlag)
            {
                return false;
            }
        }
        return true;
    }
    
    public static <In> boolean valid(In in, Class<In> inClass, IValidRule<In>... beans)
    {
        for (IValidRule<In> eachValidRule : beans)
        {
            boolean curFlag = eachValidRule.valid(in);
            if (!curFlag)
            {
                return false;
            }
        }
        return true;
    }
}
