package com.pd.ehr.atom.weather.impl;

import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.ehr.atom.weather.WeatherFo;
import com.pd.ehr.atom.weather.WeatherVo;
import com.pd.ehr.util.Json;
import com.pd.ehr.util.Json.JsonUtil;
import com.pd.ehr.util.Show;

import net.sf.json.JSONObject;

public enum WeatherChannel implements IBuilder<WeatherFo, WeatherVo>
{
    FromBaidu
    {
        @Override
        public WeatherVo build(WeatherFo _in)
        {
            String locationName = _in.getLocation().getName();
            String baiduUrl = "http://api.map.baidu.com/telematics/v3/weather?output=json&ak=W69oaDTCfuGwzNwmtVvgWfGH&location=" + locationName;
            Json.Dto.Fo jsonFo = new Json.Dto.Fo().setUrl(baiduUrl);
            JSONObject json = JsonUtil.json(jsonFo);
            Show.ln(json);
            return new WeatherVo();
        }
    };

    @Override
    public WeatherVo build(WeatherFo _in)
    {
        return FromBaidu.build(_in);
    }
    
}
