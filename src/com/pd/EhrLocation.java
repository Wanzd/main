package com.pd;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Builder.IBuilder;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;
import com.pd.EhrLocation.Dao;
import com.pd.EhrLocation.Fo;
import com.pd.EhrLocation.Service.DbService;
import com.pd.EhrLocation.Vo;
import com.pd.ehr.EhrStructure.DbAtom;
import com.pd.ehr.EhrTestCase;
import com.pd.ehr.Ip;
import com.pd.ehr.Json;
import com.pd.ehr.Show;
import com.pd.ehr.Unicode;

import net.sf.json.JSONObject;

public class EhrLocation extends DbAtom<Vo, Fo, Dao, DbService>
{
    public static enum LocationType
    {
        Street, City, Province, Country, State
    }
    
    public static class Vo extends EhrDataBaseVO
    {
        protected LocationType type = LocationType.City;
        
        protected String name;
        
        public LocationType getType()
        {
            return type;
        }
        
        public void setType(LocationType type)
        {
            this.type = type;
        }
        
        public String getName()
        {
            return name;
        }
        
        public void setName(String name)
        {
            this.name = name;
        }
        
        @Override
        public String toString()
        {
            return name;
        }
    }
    
    public static class Fo extends Vo implements IEhrFilterVO
    {
        
    }
    
    public static interface Dao extends IDao<Vo, Fo>
    {
        
    }
    
    public static class Service
    {
        public static class DbService implements IDbService<Vo, Fo, Dao>
        {
            
        }
        public static class WebService 
        {
            public EhrLocation.Vo getCurLocation()
            {
                Json.Dto.Fo fo = new Json.Dto.Fo();
                fo.setUrl("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=" + new Ip.Service.WebService().getCurW3Ip());
                String jsonResult = new Json.Service.WebService().jsonHtml(fo);
                return new Builder.ByJsonString().build(jsonResult);
            }
        }
    }
    
    public static class Builder
    {
        public static class ByJsonString implements IBuilder<String, Vo>
        {
            
            @Override
            public Vo build(String _in)
            {
                Vo resultVO = new EhrLocation.Vo();
                String cnStr = new Unicode.Builder.ToCn().build(_in);
                JSONObject jsonObject = JSONObject.fromObject(cnStr);
                String[] addressArr = jsonObject.getString("address").split("\\|");
                resultVO.setType(LocationType.City);
                resultVO.setName(addressArr[2]);
                return resultVO;
            }
            
        }
    }
    
    public static class Test extends EhrTestCase
    {
        public void testGetCurLocation()
        {
            Vo curLocation = new EhrLocation.Service.WebService().getCurLocation();
            Show.ln(curLocation);
        }
    }
}
