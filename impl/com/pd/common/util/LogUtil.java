package com.pd.common.util;

public class LogUtil
{
    private static boolean detailMode;
    
    private static boolean debugMode;
    
    public static boolean isDetailMode()
    {
        return detailMode;
    }
    
    public static void setDetailMode(boolean _detailMode)
    {
        detailMode = _detailMode;
    }
    
    public static boolean isDebugMode()
    {
        return debugMode;
    }
    
    public static void setDebugMode(boolean _debugMode)
    {
        debugMode = _debugMode;
    }
    
    public static LogService getService(String name, Class<?> class1)
    {
        
        return new LogService(name, class1);
    }
    
}
