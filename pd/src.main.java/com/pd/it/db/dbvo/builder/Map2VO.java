package com.pd.it.db.dbvo.builder;

import java.util.Map;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.vo.VO;

public class Map2VO implements IBuilder<Map<String, String>, VO>
{
    
    @Override
    public VO build(Map<String, String> in)
    {
        VO rsMap = new VO();
        for (String key : in.keySet())
        {
            rsMap.put(key, in.get(key));
        }
        return rsMap;
    }
    
}
