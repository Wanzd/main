package com.pd.common.util;

public class ViewUtil
{
    private static LogService log = LogUtil.getService("viewUtil", ViewUtil.class);
    
    public static void view(Object obj)
    {
        if (obj instanceof Object)
        {
            log.detail(obj);
        }
        else
        {
            log.detail("Null!");
        }
    }
}
