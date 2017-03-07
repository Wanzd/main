package com.pd.ehr.atom.weather;

import com.pd.ehr.atom.weather.impl.WeatherChannel;

public class Weather
{
    public static WeatherVo r(WeatherFo _fo)
    {
        return WeatherChannel.FromBaidu.build(_fo);
    }
}
