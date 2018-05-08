package com.pd.it.common.util;

import com.pd.it.common.itf.IBridge;
import com.pd.it.common.itf.IBuilder;

public class BuildUtil
{
    
    public static <In, Out> Out build(IBuilder<In, Out> builder, In... in)
    {
        if (builder == null)
        {
            return null;
        }
        return builder.build(in);
    }
    
    public static <In, Out> Out bridge(In in, IBuilder... builders)
    {
        if (builders == null)
        {
            return null;
        }
        Object out = in;
        for (IBuilder eachBuilder : builders)
        {
            if (eachBuilder == null)
            {
                return null;
            }
            out = eachBuilder.build(out);
        }
        try
        {
            Out rs = (Out)out;
            return rs;
        }
        catch (Exception e)
        {
            LogUtil.err(e);
        }
        return null;
    }
    
    public static <In, Out> Out bridge(In in, IBridge<In, Out> bridge)
    {
        // TODO Auto-generated method stub
        return bridge(in, bridge.builderArray());
    }
}
