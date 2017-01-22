package com.pd;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Builder.IBuilder;
import com.pd.EhrLocation.Dto.LocationFo;
import com.pd.EhrLocation.Dto.LocationVo;
import com.pd.EhrLocation.LocationBuilder.FromBaidu;
import com.pd.ehr.EhrTestCase;
import com.pd.ehr.Ip.IpUtil;
import com.pd.ehr.Json;
import com.pd.ehr.Json.JsonUtil;
import com.pd.ehr.Show;
import com.pd.ehr.Unicode;

import net.sf.json.JSONObject;

public class EhrLocation
{
    public static enum LocationType
    {
        Street, City, Province, Country, State
    }
    
    public static enum LocationChannel implements IBuilder<LocationFo, LocationVo>
    {
        Baidu("baidu", new FromBaidu());
        
        private String name;
        
        private IBuilder<LocationFo, LocationVo> builder;
        
        public String getName()
        {
            return name;
        }
        
        public IBuilder<LocationFo, LocationVo> getBuilder()
        {
            return builder;
        }
        
        private LocationChannel(String _name, IBuilder<LocationFo, LocationVo> _builder)
        {
            name = _name;
            builder = _builder;
        }
        
        @Override
        public LocationVo build(LocationFo _in)
        {
            // TODO Auto-generated method stub
            return builder.build(_in);
        }
        
        public static LocationVo builds(LocationFo _in)
        {
            for (LocationChannel evenChannel : LocationChannel.values())
            {
                LocationVo curVo = evenChannel.build(_in);
                if (curVo != null)
                {
                    return curVo;
                }
            }
            return null;
        }
        
    }
    
    public static class LocationUtil
    {
        
        public static LocationVo getCurLocation()
        {
            return LocationChannel.builds(null);
        }
        
    }
    
    public static class Dto
    {
        public static class LocationVo extends EhrDataBaseVO
        {
            protected LocationType type = LocationType.City;
            
            protected String name;
            
            public LocationType getType()
            {
                return type;
            }
            
            public LocationVo setType(LocationType type)
            {
                this.type = type;
                return this;
            }
            
            public String getName()
            {
                return name;
            }
            
            public LocationVo setName(String name)
            {
                this.name = name;
                return this;
            }
            
            @Override
            public String toString()
            {
                return name;
            }
        }
        
        public static class LocationFo extends LocationVo implements IEhrFilterVO
        {
            
        }
    }
    
    public static class LocationBuilder
    {
        public static class FromBaidu implements IBuilder<LocationFo, LocationVo>
        {
            
            @Override
            public LocationVo build(LocationFo _in)
            {
                // 初始化Json条件
                String curUrl = "http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=" + IpUtil.getCurW3Ip();
                Json.Dto.Fo fo = new Json.Dto.Fo().setUrl(curUrl);
                
                // Json查询
                String jsonResult = JsonUtil.html(fo);
                
                // Json解析
                String cnStr = new Unicode.Builder.ToCn().build(jsonResult);
                JSONObject jsonObject = JSONObject.fromObject(cnStr);
                String[] addressArr = jsonObject.getString("address").split("\\|");
                return new LocationVo().setType(LocationType.City).setName(addressArr[2]);
            }
            
        }
    }
    
    public static class Test extends EhrTestCase
    {
        public void testGetCurLocation()
        {
            LocationVo curLocation = LocationUtil.getCurLocation();
            Show.ln(curLocation);
        }
    }
}
