package com.pd.it.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtil
{
    private static Map<Class, Class> sClassKV = initShortClassKV();
    
    private static Map<Class, Class> initShortClassKV()
    {
        Map<Class, Class> map = null;
        map = AI.<Class, Class> map(Integer.class, int.class, Long.class, long.class);
        return map;
    }
    
    public static <Out> Out c(Class<Out> outClass, Object... in)
    {
        Out rsVO = null;
        try
        {
            rsVO = outClass.newInstance();
            u(rsVO, in);
            return rsVO;
        }
        catch (Exception e)
        {
            LogUtil.err(e);
        }
        return rsVO;
    }
    
    public static <Out> Out u(Out inOut, Object... in)
    {
        if (in.length % 2 != 0)
        {
            return inOut;
        }
        for (int i = 0; i < in.length; i += 2)
        {
            s(inOut, in[i].toString(), in[i + 1]);
        }
        return inOut;
    }
    
    public static <InOut, Attr> InOut s(InOut inOut, String k, Attr v)
    {
        Class<? extends Object> class1 = inOut.getClass();
        try
        {
            Method method = class1.getMethod("set" + StringUtil.cap(k), v.getClass());
            method.invoke(inOut, v);
        }
        catch (Exception e)
        {
            Method method;
            try
            {
                method = class1.getMethod("set" + StringUtil.cap(k), sClassKV.get(v.getClass()));
                method.invoke(inOut, v);
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        return inOut;
    }
}
