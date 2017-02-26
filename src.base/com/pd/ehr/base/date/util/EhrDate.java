package com.pd.ehr.base.date.util;

import java.util.Date;

import com.pd.ehr.base.date.impl.EhrDateImpl;

public class EhrDate
{
    
    public static String getNow()
    {
        return EhrDateImpl.getNowStr();
    }
    
    public static long timeDiff(Date startDate, Date endDate)
    {
        return EhrDateImpl.timeDiff(startDate, endDate);
    }
    
}
