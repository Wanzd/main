package com.pd.it.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
    public static String format(Date in, String pattern)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String rs = sdf.format(in);
        return rs;
    }
}
