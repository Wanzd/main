package com.pd.ehr.app.weather.dto;

import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.ehr.util.Json;
import com.pd.ehr.util.Json.JsonUtil;
import com.pd.ehr.util.Show;

import net.sf.json.JSONObject;

public class WeatherFromBaiduBuilder implements IBuilder<WeatherFo, WeatherVo>
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
    
}
