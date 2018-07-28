package com.pd.it.common.itf;

public interface IBuilder<In, Out>
{
    default Out build(In... in)
    {
        if (in == null || in.length == 0 || in[0] == null)
        {
            In a = null;
            return build(a);
        }
        return build(in[0]);
    };
    
    Out build(In in);
}
