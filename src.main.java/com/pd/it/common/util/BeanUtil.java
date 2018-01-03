package com.pd.it.common.util;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.IValidRule;

public class BeanUtil
{
    
    /** 通过反射找到指定类型的builder */
    public static <In, Out> IBuilder<In, Out> getBuilder(Class<Out> outClass, String builderBean)
    {
        String className = "builder." + outClass.getName() + "." + builderBean;
        try
        {
            Class<?> forName = Class.forName(className);
            Object newInstance = forName.newInstance();
            if (newInstance instanceof IBuilder)
            {
                return (IBuilder<In, Out>)newInstance;
            }
        }
        catch (ClassNotFoundException e)
        {
            LogUtil.err(e);
        }
        catch (InstantiationException e)
        {
            LogUtil.err(e);
        }
        catch (IllegalAccessException e)
        {
            LogUtil.err(e);
        }
        return null;
    }
    
    public static <In> IValidRule<In> getValidRule(Class<In> inClass, String bean)
    {
        String className = "validRule." + inClass.getName() + "." + bean;
        try
        {
            Class<?> forName = Class.forName(className);
            Object newInstance = forName.newInstance();
            if (newInstance instanceof IValidRule)
            {
                return (IValidRule<In>)newInstance;
            }
        }
        catch (ClassNotFoundException e)
        {
            LogUtil.err(e);
        }
        catch (InstantiationException e)
        {
            LogUtil.err(e);
        }
        catch (IllegalAccessException e)
        {
            LogUtil.err(e);
        }
        return null;
    }
}
