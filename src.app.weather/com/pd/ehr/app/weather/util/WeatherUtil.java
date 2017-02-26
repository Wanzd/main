package com.pd.ehr.app.weather.util;

import com.pd.ehr.app.weather.dto.WeatherChannel;
import com.pd.ehr.app.weather.dto.WeatherFo;
import com.pd.ehr.app.weather.dto.WeatherVo;

public class WeatherUtil
{
    public static WeatherVo r(WeatherFo _fo)
    {
        return WeatherChannel.FromBaidu.build(_fo);
    }
}
