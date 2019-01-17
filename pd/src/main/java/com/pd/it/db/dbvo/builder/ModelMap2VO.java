package com.pd.it.db.dbvo.builder;

import org.springframework.ui.ModelMap;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.vo.VO;

public class ModelMap2VO implements IBuilder<ModelMap, VO>
{
    
    @Override
    public VO build(ModelMap in)
    {
        VO rsMap = new VO();
        for (String key : in.keySet())
        {
            rsMap.put(key, in.get(key));
        }
        return rsMap;
    }
    
}
