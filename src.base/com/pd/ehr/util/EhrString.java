package com.pd.ehr.util;

public class EhrString
{
    public static class Valid
    {
        public static class IsNullOrBlank
        {
            public static boolean valid(String str)
            {
                return null == str || 0 == str.trim().length();
            }
        }
    }
}
