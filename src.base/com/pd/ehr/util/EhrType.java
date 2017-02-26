package com.pd.ehr.util;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.Base.IFilterVO;
import com.pd.base.EhrApi.Db.IDao;
import com.pd.base.EhrApi.Db.IDbService;
import com.pd.ehr.util.EhrStructure.DbAtom;
import com.pd.ehr.util.EhrType.Dao;
import com.pd.ehr.util.EhrType.FO;
import com.pd.ehr.util.EhrType.VO;
import com.pd.ehr.util.EhrType.Service.DbService;

public class EhrType extends DbAtom<VO, FO, Dao, DbService>
{
    public static class VO extends EhrDataBaseVO
    {
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
