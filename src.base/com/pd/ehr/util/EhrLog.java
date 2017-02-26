package com.pd.ehr.util;

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
        debug("start:" + EhrLogImpl.location());
    }
    
}
