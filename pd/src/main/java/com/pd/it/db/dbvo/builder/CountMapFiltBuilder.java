package com.pd.it.db.dbvo.builder;

import java.util.HashMap;
import java.util.Map;

import com.pd.it.common.itf.IBuilder;

public class CountMapFiltBuilder implements IBuilder<Map<String, Double>, Map<String, Double>>
{
    private double count = 0;
    
    public CountMapFiltBuilder(double count)
    {
        this.count = count;
    }
    
    @Override
    public Map<String, Double> build(Map<String, Double> in)
    {
        Map<String, Double> rsMap = new HashMap<String, Double>();
        for (String eachKey : in.keySet())
        {
            double curCount = in.get(eachKey);
            if (curCount < count)
            {
                continue;
            }
            rsMap.put(eachKey, curCount);
        }
        return rsMap;
    }
    
}
