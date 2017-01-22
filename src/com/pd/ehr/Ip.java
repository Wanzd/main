package com.pd.ehr;

import java.util.List;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Builder.IBuilder;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;
import com.pd.ehr.EhrStructure.DbAtom;
import com.pd.ehr.Ip.Dao;
import com.pd.ehr.Ip.Dto.FO;
import com.pd.ehr.Ip.Dto.VO;
import com.pd.ehr.Ip.Service.DbService;
import com.pd.ehr.Ip.Service.WebService;

public class Ip extends DbAtom<VO, FO, Dao,  DbService>
{
    public static class Service
    {
        public static class WebService
        {
            
            public String getCurW3Ip()
            {
                Json.Dto.FO fo = new Json.Dto.FO();
                fo.setUrl("http://1212.ip138.com/ic.asp");
                String json = new Json.Service.WebService().json(fo);
                Show.ln(json);
                return new Builder.IpStrBuilder.ByJsonStr().build(json);
            }
            
        }
        
        public static class DbService implements IDbService<VO, FO, Dao>
        {
            
        }
    }
    
    public static class Builder
    {
        public static class IpStrBuilder
        {
            public static class ByJsonStr implements IBuilder<String, String>
            {

                @Override
                public String build(String _in)
                {
                    int startIndex= _in.indexOf("[");
                    int endIndex= _in.indexOf("]");
                    return _in.substring(startIndex+1,endIndex);
                }
                
            }
        }
    }
    
    public static class Dto
    {
        public static class VO extends EhrDataBaseVO
        {
            protected String ip;
            
        }
        
        public static class FO extends VO implements IEhrFilterVO
        {
            
        }
    }
    
    public static interface Dao extends IDao<VO, FO>
    {
        
    }
    
    
    public static class Action
    {
        public static class ListNewsAction
        {
            public List<VO> list(FO fo)
            {
                return null;
            }
        }
    }
    
    public static class Test extends EhrTestCase
    {
        public void testGetSelfPublicIp()
        {
            WebService webService = new Ip.Service.WebService();
            String result = webService.getCurW3Ip();
            Show.ln(result);
        }
    }
}
