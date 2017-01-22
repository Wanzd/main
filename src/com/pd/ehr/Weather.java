package com.pd.ehr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.pd.ehr.Weather.Dto.Fo;
import com.pd.ehr.Weather.Dto.Vo;
import com.pd.ehr.Weather.Service.DbService;
import com.pd.ehr.Weather.Service.WebService;

public class Weather extends DbAtom<Vo, Fo, Dao, DbService>
{
    public static class Service
    {
        public static class WebService
        {
            public List<Vo> list(Fo fo)
            {
                return new Weather.Action.ListWeatherAction().list(fo);
            }
        }
        
        public static class DbService implements IDbService<Vo, Fo, Dao>
        {
            
        }
    }
    
    public static class Dto
    {
        public static class Vo extends EhrDataBaseVO
        {
            protected String title;
            
            protected EhrObject author;
        }
        
        public static class Fo extends Vo implements IEhrFilterVO
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
    
    public static interface Dao extends IDao<Vo, Fo>
    {
        
    }
    
    
    public static class Channel
    {
        private static List<IBuilder<Fo, Vo>> list;
        {
            list = new ArrayList<IBuilder<Fo, Vo>>();
            list.add(new Builder.FromBaidu());
        }
        
        public static List<IBuilder<Fo, Vo>> getChannelList()
        {
            return list;
        }
    }
    
    public static class Action
    {
        public static class ListWeatherAction
        {
            public List<Vo> list(Fo fo)
            {
                List<Vo> resultList = new ArrayList<Vo>();
                List<IBuilder<Fo, Vo>> channelList = Channel.getChannelList();
                if (NotEmpty.valid(channelList))
                {
                    for (IBuilder<Fo, Vo> evenBuilder : channelList)
                    {
                        Vo buildVo = evenBuilder.build(fo);
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
        public static class FromBaidu implements IBuilder<Fo, Vo>
        {
            
            @Override
            public Vo build(Fo _in)
            {
                String baiduUrl = "http://apis.baidu.com/heweather/weather/free?city=wuhan";
                Json.Dto.Fo jsonFo = new Json.Dto.Fo();
                jsonFo.setUrl(baiduUrl);
                String json = new Json.Service.WebService().jsonStr(jsonFo);
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
            Fo fo = new Fo();
            fo.setDate(new Date());
            fo.setLocation(new EhrLocation.Service.WebService().getCurLocation());
            List<Vo> list = webService.list(fo);
            Show.ln(list);
        }
    }
}
