package com.pd.it.db.dbvo.builder;

import java.util.HashMap;
import java.util.Map;

import com.pd.it.common.itf.IBuilder;

public class CountMapFiltBuilder implements IBuilder<Map<String, Integer>, Map<String, Integer>>
{
    private int count = 0;
    
    public CountMapFiltBuilder(int count)
    {
        this.count = count;
    }
    
    @Override
    public Map<String, Integer> build(Map<String, Integer> in)
    {
        Map<String, Integer> rsMap = new HashMap<String, Integer>();
        for (String eachKey : in.keySet())
        {
            int curCount = in.get(eachKey);
            if (curCount < count)
            {
                continue;
            }
            rsMap.put(eachKey, curCount);
        }
        return rsMap;
    }
    
}
