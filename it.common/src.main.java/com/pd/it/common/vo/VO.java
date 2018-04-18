package com.pd.it.common.vo;

import java.util.HashMap;
import java.util.Map;

public class VO extends HashMap<String, Object>
{
    private static final long serialVersionUID = 8344639996353937629L;
    
    public VO()
    {
        
    }
    
    public VO(Map<String, Object> map)
    {
        super();
        if (map == null)
        {
            return;
        }
        for (String eachKey : map.keySet())
        {
            put(eachKey, map.get(eachKey));
        }
    }
}
