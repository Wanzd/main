package com.pd.it.common.util;

public class StrU
{
    
    public static final String BLANK = "";
    
    public static String nvl(String... inStr)
    {
        if (inStr == null || inStr.length == 0)
        {
            return "";
        }
        if (inStr[0] != null)
        {
            return inStr[0];
        }
        if (inStr.length == 1)
        {
            return inStr[0] != null ? inStr[0] : BLANK;
        }
        return inStr[1];
    }
    
    public static String cap(String in)
    {
        if (in == null)
        {
            return null;
        }
        if (in.length() < 1)
        {
            return BLANK;
        }
        return in.substring(0, 1).toUpperCase() + in.substring(1);
    }
    
}
