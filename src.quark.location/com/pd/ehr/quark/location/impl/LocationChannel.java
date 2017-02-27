package com.pd.ehr.quark.location.impl;

import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.ehr.quark.location.vo.LocationFo;
import com.pd.ehr.quark.location.vo.LocationVo;

public enum LocationChannel implements IBuilder<LocationFo, LocationVo>
{
    Baidu(new LocationFromBaiduBuilder());
    
    private IBuilder<LocationFo, LocationVo> builder;
    
    private LocationChannel(IBuilder<LocationFo, LocationVo> _builder)
    {
        builder = _builder;
    }
    
    @Override
    public LocationVo build(LocationFo _in)
    {
        // TODO Auto-generated method stub
        return builder.build(_in);
    }
    
}
