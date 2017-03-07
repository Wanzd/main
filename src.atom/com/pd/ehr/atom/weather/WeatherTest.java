package com.pd.ehr.atom.weather;

import java.util.Date;

import com.pd.ehr.quark.location.LocationUtil;
import com.pd.ehr.util.EhrTestCase;
import com.pd.ehr.util.Show;

public class WeatherTest extends EhrTestCase
{
    public void testLocalTodayWeather()
    {
        WeatherFo fo = new WeatherFo();
        fo.setDate(new Date());
        fo.setLocation(LocationUtil.getCurLocation());
        WeatherVo weatherVo = Weather.r(fo);
        Show.ln(weatherVo);
    }
}