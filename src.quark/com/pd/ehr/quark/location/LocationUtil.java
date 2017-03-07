package com.pd.ehr.quark.location;

public class LocationUtil
{
    
    public static LocationVo getCurLocation()
    {
        
        return LocationChannel.Baidu.build(null);
    }
    
}
