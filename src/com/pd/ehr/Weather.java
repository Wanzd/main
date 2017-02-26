package com.pd.ehr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Builder.IBuilder;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrLocation.Dto.LocationVo;
import com.pd.EhrLocation.LocationUtil;
import com.pd.ehr.EhrDateImpl.DateSdf;
import com.pd.ehr.Json.JsonUtil;
import com.pd.ehr.Weather.Builder.FromBaidu;
import com.pd.ehr.Weather.Dto.WeatherFo;
import com.pd.ehr.Weather.Dto.WeatherVo;

import net.sf.json.JSONObject;

public class Weather
{
    public static enum WeatherChannel implements IBuilder<WeatherFo, WeatherVo>
    {
        Baidu("baidu", new FromBaidu());
        
        private String name;
        
        private IBuilder<WeatherFo, WeatherVo> builder;
        
        public String getName()
        {
            return name;
        }
        
        public IBuilder<WeatherFo, WeatherVo> getBuilder()
        {
            return builder;
        }
        
        private WeatherChannel(String _name, IBuilder<WeatherFo, WeatherVo> _builder)
        {
            name = _name;
            builder = _builder;
        }
        
        @Override
        public WeatherVo build(WeatherFo _in)
        {
            return builder.build(_in);
        }
        
        public static WeatherVo builds(WeatherFo _in)
        {
            for (WeatherChannel evenChannel : WeatherChannel.values())
            {
                WeatherVo curVo = evenChannel.build(_in);
                if (curVo != null)
                {
                    return curVo;
                }
            }
            return null;
        }
    }
    
    public static class WeatherUtil
    {
        public static WeatherVo r(WeatherFo _fo)
        {
            return WeatherChannel.builds(_fo);
        }
    }
    
    public static class Dto
    {
        public static class WeatherVo extends EhrDataBaseVO
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
            
            public WeatherVo setDate(Date date)
            {
                this.date = date;
                return this;
            }
            
            public LocationVo getLocation()
            {
                return location;
            }
            
            public WeatherVo setLocation(LocationVo location)
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
        
        public static class WeatherFo extends WeatherVo implements IEhrFilterVO
        {
            
        }
    }
    
    public static interface Dao extends IDao<WeatherVo, WeatherFo>
    {
        
    }
    
    public static class Channel
    {
        private static List<IBuilder<WeatherFo, WeatherVo>> list;
        {
            list = new ArrayList<IBuilder<WeatherFo, WeatherVo>>();
            list.add(new Builder.FromBaidu());
        }
        
        public static List<IBuilder<WeatherFo, WeatherVo>> getChannelList()
        {
            return list;
        }
    }
    
    public static class Builder
    {
        public static class FromBaidu implements IBuilder<WeatherFo, WeatherVo>
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
    }
    
    public static class Test extends EhrTestCase
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
}
