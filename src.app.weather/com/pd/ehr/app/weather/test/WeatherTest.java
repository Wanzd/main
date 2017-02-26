package com.pd.ehr.app.weather.test;

import java.util.Date;

import com.pd.base.location.EhrLocation.LocationUtil;
import com.pd.ehr.app.weather.dto.WeatherFo;
import com.pd.ehr.app.weather.dto.WeatherVo;
import com.pd.ehr.app.weather.util.WeatherUtil;
import com.pd.ehr.util.EhrTestCase;
import com.pd.ehr.util.Show;

public class WeatherTest extends EhrTestCase
{
    public void testLocalTodayWeather()
    {
        WeatherFo fo = new WeatherFo();
        fo.setDate(new Date());
        fo.setLocation(LocationUtil.getCurLocation());
        WeatherVo weatherVo = WeatherUtil.r(fo);
        Show.ln(weatherVo);
    }
}