package com.pd.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ValidUtil
{
    public static List<String> valid(Object obj, String[] matches)
    {
        List<String> resultList = new ArrayList<String>();
        if (matches != null && matches.length > 0)
        {
            for (String matchStr : matches)
            {
                resultList.addAll(valid(obj, matchStr));
            }
        }
        return resultList;
    }
    
    public static List<String> valid(Object obj, String matches)
    {
        if (obj == null)
        {
            
            return null;
        }
        List<String> resultList = new ArrayList<String>();
        
        if (matches.equals("'FILE'"))
        {
            if (!(obj instanceof File))
            {
                resultList.add("");
            }
            else if (!((File)obj).isFile())
            {
                resultList.add("");
            }
        }
        
        return resultList;
    }
}
