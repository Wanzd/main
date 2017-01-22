package com.pd.ehr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pd.Base.EhrBaseModule.IValidator;
import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Builder.IBuilder;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;
import com.pd.EhrLocation;
import com.pd.ehr.EhrCollection.Valid.NotEmpty;
import com.pd.ehr.EhrStructure.DbAtom;
import com.pd.ehr.EhrValid.NotNull;
import com.pd.ehr.Weather.Dao;
import com.pd.ehr.Weather.Dto.FO;
import com.pd.ehr.Weather.Dto.VO;
import com.pd.ehr.Weather.Service.DbService;
import com.pd.ehr.Weather.Service.WebService;

public class Weather extends DbAtom<VO, FO, Dao, DbService>
{
    public static class Service
    {
        public static class WebService
        {
            public List<VO> list(FO fo)
            {
                return new Weather.Action.ListWeatherAction().list(fo);
            }
        }
        
        public static class DbService implements IDbService<VO, FO, Dao>
        {
            
        }
    }
    
    public static class Dto
    {
        public static class VO extends EhrDataBaseVO
        {
            protected String title;
            
            protected EhrObject author;
        }
        
        public static class FO extends VO implements IEhrFilterVO
        {
            private Date date;
            
            private EhrLocation.Vo location;
            
            public Date getDate()
            {
                return date;
            }
            
            public void setDate(Date date)
            {
                this.date = date;
            }
            
            public EhrLocation.Vo getLocation()
            {
                return location;
            }
            
            public void setLocation(EhrLocation.Vo location)
            {
                this.location = location;
            }
        }
    }
    
    public static interface Dao extends IDao<VO, FO>
    {
        
    }
    
    public static class Validator implements IValidator<VO, FO, Dao>
    {
        
    }
    
    public static class Channel
    {
        private static List<IBuilder<FO, VO>> list;
        {
            list = new ArrayList<IBuilder<FO, VO>>();
            list.add(new Builder.FromBaidu());
        }
        
        public static List<IBuilder<FO, VO>> getChannelList()
        {
            return list;
        }
    }
    
    public static class Action
    {
        public static class ListWeatherAction
        {
            public List<VO> list(FO fo)
            {
                List<VO> resultList = new ArrayList<VO>();
                List<IBuilder<FO, VO>> channelList = Channel.getChannelList();
                if (NotEmpty.valid(channelList))
                {
                    for (IBuilder<FO, VO> evenBuilder : channelList)
                    {
                        VO buildVo = evenBuilder.build(fo);
                        if (NotNull.valid(buildVo))
                        {
                            resultList.add(buildVo);
                        }
                    }
                }
                return resultList;
            }
        }
    }
    
    public static class Builder
    {
        public static class FromBaidu implements IBuilder<FO, VO>
        {
            
            @Override
            public VO build(FO _in)
            {
                String baiduUrl = "http://apis.baidu.com/heweather/weather/free?city=wuhan";
                Json.Dto.FO jsonFo = new Json.Dto.FO();
                jsonFo.setUrl(baiduUrl);
                String json = new Json.Service.WebService().json(jsonFo);
                Show.ln(json);
                return null;
            }
            
        }
    }
    
    public static class Test extends EhrTestCase
    {
        public void testLocalTodayWeather()
        {
            WebService webService = new Weather.Service.WebService();
            FO fo = new FO();
            fo.setDate(new Date());
            fo.setLocation(new EhrLocation.Service.WebService().getCurLocation());
            List<VO> list = webService.list(fo);
            Show.ln(list);
        }
    }
}
