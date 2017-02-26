package com.pd.ehr.app.weather.dto;

import java.util.Date;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.location.dto.LocationVo;
import com.pd.ehr.base.date.impl.EhrDateImpl.DateSdf;

public class WeatherFo extends EhrDataBaseVO
{
    protected String title;
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    protected Date date;
    
    protected LocationVo location;
    
    public Date getDate()
    {
        return date;
    }
    
    public WeatherFo setDate(Date date)
    {
        this.date = date;
        return this;
    }
    
    public LocationVo getLocation()
    {
        return location;
    }
    
    public WeatherFo setLocation(LocationVo location)
    {
        this.location = location;
        return this;
    }
    
    @Override
    public String toString()
    {
        return String.format("city:%s,date:%s,title:%s", location.getName(), DateSdf.Date.format(date), title);
    }
}