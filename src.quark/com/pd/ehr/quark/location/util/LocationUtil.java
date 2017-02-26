package com.pd.ehr.quark.location.util;

import com.pd.ehr.quark.location.impl.LocationChannel;
import com.pd.ehr.quark.location.vo.LocationVo;

public class LocationUtil
{
    
    public static LocationVo getCurLocation()
    {
        
        return LocationChannel.Baidu.build(null);
    }
    
}
