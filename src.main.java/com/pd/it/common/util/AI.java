package com.pd.it.common.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.IValidRule;

public class AI
{
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
            Method method = class1.getMethod("set" + StrU.cap(k), v.getClass());
            method.invoke(inOut, v);
        }
        catch (Exception e)
        {
            LogUtil.err(e);
        }
        return inOut;
    }
    
    public static <In, Out> Out build(In in, Class<Out> outClass, IBuilder<In,Out> builder)
    {
        return BuildUtil.build(in, outClass, builder);
    }
    public static <In, Out> Out build(In in, Class<Out> outClass, String builderBean)
    {
        return BuildUtil.build(in, outClass, builderBean);
    }
    public static <In> boolean valid(In in, Class<In> inClass, String beansStr)
    {
        return ValidUtil.valid(in, inClass, beansStr);
    }
    
    public static <In> boolean valid(In in, Class<In> inClass, IValidRule<In>... beans)
    {
        return ValidUtil.valid(in, inClass, beans);
    }
    
    public static String nvl(String... inStr)
    {
        return StrU.nvl(inStr);
    }
    
    public static Map<String, Object> map(Object... in)
    {
        Map<String, Object> outMap = new HashMap<String, Object>();
        if (in.length % 2 != 0)
        {
            return outMap;
        }
        for (int i = 0; i < in.length; i += 2)
        {
            outMap.put(in[i].toString(), in[i + 1]);
        }
        return outMap;
    }
}
