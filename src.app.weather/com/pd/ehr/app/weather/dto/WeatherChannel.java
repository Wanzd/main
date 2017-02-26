package com.pd.ehr.app.weather.dto;

import com.pd.base.EhrApi.Builder.IBuilder;

public enum WeatherChannel implements IBuilder<WeatherFo, WeatherVo>
{
    FromBaidu(new WeatherFromBaiduBuilder());
    private IBuilder<WeatherFo, WeatherVo> builder;
    
    private WeatherChannel(IBuilder<WeatherFo, WeatherVo> _builder)
    {
        builder = _builder;
    }
    
    @Override
    public WeatherVo build(WeatherFo _in)
    {
        return builder.build(_in);
    };
}
