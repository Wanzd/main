package com.pd.it.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pd.it.common.vo.VO;

public class X
{
    public static String v(VO in, String key)
    {
        Object value = in.get(key);
        return value == null ? null : value.toString();
        
    }
    
    public static <In> List<VO> map2voList(Map<String, In> rsMap, String keyAttrName, String valueAttrName)
    {
        List<VO> rsList = new ArrayList<VO>();
        for (String eachKey : rsMap.keySet())
        {
            rsList.add(new VO(keyAttrName, eachKey).nvl(valueAttrName, rsMap.get(eachKey)));
        }
        return rsList;
    }
    
    public static String cn2unicode(final String cnStr)
    {
        char[] utfBytes = cnStr.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++)
        {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2)
            {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }
    
    public static String unicode2cn(String dataStr)
    {
        int start = 0;
        int end = -1;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1)
        {
            end = dataStr.indexOf("\\u", start);
            String charStr = "";
            if (end > start)
            {
                charStr = dataStr.substring(start, end);
                buffer.append(charStr);
            }
            else if (end == start)
            {
                end = start + 6;
                charStr = dataStr.substring(start + 2, end);
                char letter = (char)Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
                
                buffer.append(new Character(letter).toString());
            }
            else
            {
                charStr = dataStr.substring(start);
                buffer.append(charStr);
            }
            start = end;
        }
        return buffer.toString();
    }
    
}
