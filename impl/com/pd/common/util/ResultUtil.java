package com.pd.common.util;

public class ResultUtil
{
    public static String trans(String rs)
    {
        String result = "";
        if (rs != null)
        {
            result = rs;
        }
        else
        {
            result = "not found";
        }
        return result;
    }
}
