package com.pd.ehr;

import java.util.List;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.Base.PageList;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;
import com.pd.ehr.EhrStructure.DbAtom;
import com.pd.ehr.User.Dao;
import com.pd.ehr.User.DbService;
import com.pd.ehr.User.FO;
import com.pd.ehr.User.VO;

public class User extends DbAtom<VO, FO, Dao,  DbService>
{
    public static class VO extends EhrDataBaseVO
    {
        
    }
    
    public static class FO extends VO implements IEhrFilterVO
    {
        
    }
    
    public static class Dao implements IDao<VO, FO>
    {

        @Override
        public long nextSeq()
        {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public VO r(FO vo)
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public List<VO> rs(FO vo)
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public PageList<VO> p(FO fo)
        {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int c(List<VO> list)
        {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int u(List<VO> list)
        {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int d(List<VO> list)
        {
            // TODO Auto-generated method stub
            return 0;
        }
        
    }
    
    
    public static class DbService implements IDbService<VO, FO, Dao>
    {
        
    }
    
    public static class Test extends EhrTestCase
    {
        
    }
}
