package com.pd.base.location;

import com.pd.base.Base.IFilterVO;
import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.base.location.EhrLocation.Dto.LocationFo;
import com.pd.base.location.EhrLocation.LocationBuilder.LocationFromBaiduBuilder;
import com.pd.base.location.dto.LocationVo;
import com.pd.ehr.util.EhrTestCase;
import com.pd.ehr.util.Ip.IpUtil;
import com.pd.ehr.util.Json;
import com.pd.ehr.util.Json.JsonUtil;
import com.pd.ehr.util.Show;
import com.pd.ehr.util.Unicode;

import net.sf.json.JSONObject;

public class EhrLocation
{
    public static enum LocationType
    {
        Street, City, Province, Country, State
    }
    
    public static enum LocationChannel implements IBuilder<LocationFo, LocationVo>
    {
        Baidu("baidu", new LocationFromBaiduBuilder());
        
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
        
        public static class LocationFo extends LocationVo implements IFilterVO
        {
            
        }
    }
    
    public static class LocationBuilder
    {
        public static class LocationFromBaiduBuilder implements IBuilder<LocationFo, LocationVo>
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
                LocationVo locationVo = new LocationVo();
                locationVo.setType(LocationType.City);
                locationVo.setName(addressArr[2]);
                return locationVo;
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
