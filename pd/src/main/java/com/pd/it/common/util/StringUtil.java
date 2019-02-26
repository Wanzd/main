package com.pd.it.common.util;

public class StringUtil
{
    
    public static final String BLANK = "";
    
    public static String left(String in, int count)
    {
        if (in == null)
        {
            return null;
        }
        if (count > in.length())
        {
            return in;
        }
        return in.substring(0, count);
    }
    
    public static String right(String in, int count)
    {
        if (in == null)
        {
            return null;
        }
        if (count > in.length())
        {
            return in;
        }
        return in.substring(in.length() - count);
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
