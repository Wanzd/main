package com.pd.it.db.dbvo.builder;

import java.util.HashMap;
import java.util.Map;

import com.pd.it.common.itf.IBuilder;

public class MaxMatchFiltBuilder implements IBuilder<Map<String, Double>, Map<String, Double>>
{
    
    @Override
    public Map<String, Double> build(Map<String, Double> in)
    {
        Map<String, Double> rsMap = new HashMap<String, Double>();
        l1: for (String eachKey : in.keySet())
        {
            
            l2: for (String eachKey2 : in.keySet())
            {
                if (eachKey2.equals(eachKey))
                {
                    continue l2;
                }
                if ((eachKey2.startsWith(eachKey) || eachKey2.endsWith(eachKey) || eachKey2.contains(eachKey))
                    && (in.get(eachKey2) >= in.get(eachKey) * 0.4))
                {
                    continue l1;
                }
            }
            rsMap.put(eachKey, in.get(eachKey));
        }
        return rsMap;
    }
    
}
