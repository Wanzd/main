package com.pd.ehr;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;
import com.pd.ehr.EhrObject.Dao;
import com.pd.ehr.EhrObject.FO;
import com.pd.ehr.EhrObject.Service.DbService;
import com.pd.ehr.EhrObject.VO;
import com.pd.ehr.EhrStructure.DbAtom;

public class EhrObject extends DbAtom<VO, FO, Dao,  DbService>
{
    public static class VO extends EhrDataBaseVO
    {
        protected VO parent;
        
        protected EhrType.VO type;
    }
    
    public static class FO extends VO implements IEhrFilterVO
    {
        
    }
    
    public static interface Dao extends IDao<VO, FO>
    {
        
    }
    
    
    public static class Service
    {
        public static class DbService implements IDbService<VO, FO, Dao>
        {
            
        }
    }
    
    public static class Test extends EhrTestCase
    {
    }
}
