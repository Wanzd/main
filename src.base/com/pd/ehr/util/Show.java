package com.pd.ehr.util;

import junit.framework.TestCase;

public class Show
{
    public static String str(Object obj)
    {
        if (null == obj)
        {
            return "null";
        }
        if (obj instanceof Object[])
        {
            StringBuilder sBuilder = new StringBuilder();
            Object[] tmpArray = (Object[])obj;
            sBuilder.append("[Array|" + tmpArray.length + "]\n");
            for (Object evenObj : (Object[])obj)
            {
                sBuilder.append("\t" + str(evenObj) + "\n");
            }
            return sBuilder.toString();
        }
        else if (obj instanceof String)
        {
            return obj.toString();
        }
        else
        {
            return obj.getClass().getName() + "|" + obj.toString();
        }
    }
    
    public static void ln(Object obj)
    {
        System.out.println(str(obj));
    }
    
    public static class Test extends TestCase
    {
        public void testLnString()
        {
            Show.ln("abc");
        }
        
        public void testLnArray()
        {
            String[] a = new String[] {"a", "b", "c"};
            Show.ln(a);
        }
    }
}
