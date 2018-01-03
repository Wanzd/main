package com.pd.it.common.util;

import com.pd.it.common.itf.IBuilder;

public class BuildUtil
{
    public static <In, Out> Out build(In in, Class<Out> outClass, String builderBean)
    {
        IBuilder<In, Out> builder = BeanUtil.<In, Out> getBuilder(outClass, builderBean);
        return build(in, outClass, builder);
    }
    
    public static <In, Out> Out build(In in, Class<Out> outClass, IBuilder<In, Out> builder)
    {
        if (builder == null)
        {
            return null;
        }
        return builder.build(in);
    }
}
