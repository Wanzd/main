package com.pd.it.common.abs;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ICheck;
import com.pd.it.common.itf.ICheckIn;
import com.pd.it.common.itf.ILogic;

public abstract class AbsCheckBuilder<In, Out> implements IBuilder<In, Out>, ILogic<In, Out>, ICheckIn<In>, ICheck<In>
{
    @Override
    public Out build(In in)
    {
        if (!checkIn(in))
        {
            return null;
        }
        if (!check(in))
        {
            return null;
        }
        return logic(in);
    }
}
