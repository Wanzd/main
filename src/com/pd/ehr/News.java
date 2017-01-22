package com.pd.ehr;

import java.util.List;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;
import com.pd.ehr.EhrStructure.DbAtom;
import com.pd.ehr.News.Dao;
import com.pd.ehr.News.Dto.FO;
import com.pd.ehr.News.Dto.VO;
import com.pd.ehr.News.Service.DbService;
import com.pd.ehr.News.Service.WebService;

public class News extends DbAtom<VO, FO, Dao,DbService>
{
    public static class Service
    {
        public static class WebService
        {
            public List<VO> list(FO fo)
            {
                return new News.Action.ListNewsAction().list(fo);
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
        public void testTop10News()
        {
            WebService webService = new News.Service.WebService();
            List<VO> list = webService.list(null);
            Show.ln(list);
        }
    }
}
