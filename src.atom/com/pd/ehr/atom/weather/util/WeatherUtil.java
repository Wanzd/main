package com.pd.ehr.atom.weather.util;

import com.pd.ehr.atom.weather.dto.WeatherFo;
import com.pd.ehr.atom.weather.dto.WeatherVo;
import com.pd.ehr.atom.weather.impl.WeatherChannel;

public class WeatherUtil
{
    public static WeatherVo r(WeatherFo _fo)
    {
        return WeatherChannel.FromBaidu.build(_fo);
    }
}
