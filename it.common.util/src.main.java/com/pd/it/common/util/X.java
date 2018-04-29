package com.pd.it.common.util;

import com.pd.it.common.vo.VO;

public class X
{
    public static String v(VO in, String key)
    {
        Object value = in.get(key);
        return value == null ? null : value.toString();
        
    }
}
