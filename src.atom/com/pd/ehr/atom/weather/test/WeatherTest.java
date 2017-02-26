package com.pd.ehr.atom.weather.test;

import java.util.Date;

import com.pd.ehr.atom.weather.dto.WeatherFo;
import com.pd.ehr.atom.weather.dto.WeatherVo;
import com.pd.ehr.atom.weather.util.WeatherUtil;
import com.pd.ehr.quark.location.util.LocationUtil;
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