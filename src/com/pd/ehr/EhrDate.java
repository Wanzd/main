package com.pd.ehr;

import java.util.Date;

public class EhrDate extends EhrDateImpl
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
