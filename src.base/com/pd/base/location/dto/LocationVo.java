package com.pd.base.location.dto;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.location.EhrLocation.LocationType;

public class LocationVo extends EhrDataBaseVO
{
    protected LocationType type = LocationType.City;
    
    public LocationType getType()
    {
        return type;
    }
    
    public LocationVo setType(LocationType type)
    {
        this.type = type;
        return this;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
}