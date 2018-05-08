package com.pd.it.common.itf;

public interface IBuilder<In, Out>
{
    default Out build(In... in)
    {
        if (in == null || in[0] == null)
        {
            return null;
        }
        return build(in[0]);
    };
    
    Out build(In in);
}
