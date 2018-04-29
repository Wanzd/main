package com.pd.it.common.vo;

import java.util.HashMap;

public class KV extends HashMap<String, String>
{
    private static final long serialVersionUID = 8344639996353937629L;
    
    public KV()
    {
        
    }
    
    public KV(HashMap<String, String> vo)
    {
        super();
        if (vo == null)
        {
            return;
        }
        for (String eachKey : vo.keySet())
        {
            Object value = vo.get(eachKey);
            
            put(eachKey, value == null ? null : value.toString());
        }
    }
    
    public KV(VO vo)
    {
        super();
        if (vo == null)
        {
            return;
        }
        for (String eachKey : vo.keySet())
        {
            Object value = vo.get(eachKey);
            put(eachKey, value == null ? null : value.toString());
            if (value instanceof String)
            {
                put(eachKey, String.format("'%s'", value));
            }
        }
    }
    
    public String v(String key)
    {
        String value = get(key);
        return value == null ? "" : value;
    }
}
