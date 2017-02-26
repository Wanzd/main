package com.pd.ehr.base.date.impl;

import java.util.Date;

import com.pd.ehr.base.date.impl.EhrDateImpl.DateSdf;

class EhrDateHelper
{
    
    public static String getNowStr()
    {
        Date now = new Date();
        return DateSdf.DateTime.format(now);
        
    }
    
    public static long timeDiff(Date startDate, Date endDate)
    {
        if (startDate == null || endDate == null)
        {
            return -1;
        }
        return endDate.getTime() - startDate.getTime();
    }
    
}
