package com.pd.ehr;

public class EhrLog
{
    public static void log(String _in)
    {
        System.out.println(_in);
    }
    
    public static void debug(String _in)
    {
        System.out.println("\t" + _in);
    }
    
    public static void start()
    {
        debug("start:" + Helper.location());
    }
    
    static class Helper
    {
        public static String location()
        {
            Exception exception = new Exception();
            StackTraceElement stackTraceElement = exception.getStackTrace()[2];
            return String.format("%s.%s", stackTraceElement.getClassName(), stackTraceElement.getMethodName());
        }
    }
}
