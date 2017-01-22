package com.pd.ehr;

public class EhrValid
{
    public static class NotNull
    {
        public static boolean valid(Object obj)
        {
            return null != obj;
        }
    }
    
    public static class IsNull
    {
        public static boolean valid(Object obj)
        {
            return null == obj;
        }
    }
}
