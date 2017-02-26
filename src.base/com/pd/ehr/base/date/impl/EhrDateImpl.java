package com.pd.ehr.base.date.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EhrDateImpl extends EhrDateHelper
{
    public static enum DateSdf
    {
        DateTime("yyyy-MM-dd HH:mm:ss"), Date("yyyy-MM-dd");
        private SimpleDateFormat formatter;
        
        private DateSdf(String _formatStr)
        {
            formatter = new SimpleDateFormat(_formatStr);
        }
        
        public String format(Date _date)
        {
            return formatter.format(_date);
        }
    }
    
    public static String getNow()
    {
        return EhrDateHelper.getNowStr();
    }
    
    public static long timeDiff(Date startDate, Date endDate)
    {
        return EhrDateHelper.timeDiff(startDate, endDate);
    }
    
}
