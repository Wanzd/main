package com.pd.ehr.util;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.Base.IFilterVO;
import com.pd.base.EhrApi.Db.IDao;
import com.pd.base.EhrApi.Db.IDbService;
import com.pd.ehr.util.EhrObject.Dao;
import com.pd.ehr.util.EhrObject.FO;
import com.pd.ehr.util.EhrObject.VO;
import com.pd.ehr.util.EhrObject.Service.DbService;
import com.pd.ehr.util.EhrStructure.DbAtom;

public class EhrObject extends DbAtom<VO, FO, Dao,  DbService>
{
    public static class VO extends EhrDataBaseVO
    {
        protected VO parent;
        
        protected EhrType.VO type;
    }
    
    public static class FO extends VO implements IFilterVO
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
