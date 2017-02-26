package com.pd.ehr.util;

import java.util.List;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.Base.IFilterVO;
import com.pd.base.EhrApi.Db.IDao;
import com.pd.base.EhrApi.Db.IDbService;
import com.pd.ehr.util.EhrStructure.DbAtom;
import com.pd.ehr.util.News.Dao;
import com.pd.ehr.util.News.Dto.FO;
import com.pd.ehr.util.News.Dto.VO;
import com.pd.ehr.util.News.Service.DbService;
import com.pd.ehr.util.News.Service.WebService;

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
        
        public static class FO extends VO implements IFilterVO
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
