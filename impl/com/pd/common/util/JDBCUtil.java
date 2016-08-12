package com.pd.common.util;

import java.util.Locale;

public class JDBCUtil
{
    public static String getUrlByType(String type, String url)
    {
        String result = null;
        String preUrl = null;
        String jdbcType = type.toLowerCase(Locale.ENGLISH);
        // switch (jdbcType)
        // {
        // case "mysql":
        // preUrl = "jdbc:mysql:";
        // break;
        //            
        // default:
        // break;
        // }
        if (null != preUrl)
        {
            result = String.format("%s//%s", preUrl, url);
        }
        return result;
    }
}
