package com.pd.ehr.base.log.util;

class EhrLogImpl
{
    public static String location()
    {
        Exception exception = new Exception();
        StackTraceElement stackTraceElement = exception.getStackTrace()[2];
        return String.format("%s.%s", stackTraceElement.getClassName(), stackTraceElement.getMethodName());
    }
}
