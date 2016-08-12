package com.pd.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.pd.common.vo.NDate;

public class DateUtil
{
    private static final SimpleDateFormat dtSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private static final SimpleDateFormat dSDF = new SimpleDateFormat("yyyy-MM-dd");
    
    public static String getNow()
    {
        Date now = new Date();
        return dtSDF.format(now);
    }
    
    public static String getDate(Date date)
    {
        if (date == null)
        {
            return "";
        }
        return dSDF.format(date);
    }
    
    public static NDate getNDate(Date date)
    {
        return new NDate(date);
    }
}
