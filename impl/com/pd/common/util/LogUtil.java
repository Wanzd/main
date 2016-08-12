package com.pd.common.util;

import java.util.logging.Logger;

public class LogUtil
{
    private static boolean debugMode = false;
    
    private static boolean detailMode = false;
    
    public static void setDebug(boolean flag)
    {
        debugMode = flag;
    }
    
    public static void setDetail(boolean flag)
    {
        detailMode = flag;
    }
    
    private static void log(String type, Object msg)
    {
        String msg2 = String.format("[ %s ]%s", type, DateUtil.getNow(), msg);
        // switch (type)
        // {
        // case "info":
        //                
        // case "error":
        // case "debug":
        // case "detail":
        // case "warning":
        // default:
        // }
        System.out.println(msg);
    }
    
    public static void debug(Object msg)
    {
        if (debugMode)
        {
            log("debug", msg);
        }
    }
    
    public static void detail(Object msg)
    {
        if (detailMode)
        {
            log("detail", msg);
        }
    }
    
    public static Logger getLogger(Class<?> class1)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
