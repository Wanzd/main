package com.pd.it.common.itf;

public interface IBridge<In, Out>
{
    IBuilder<Object, Object>[] builderArray();
}