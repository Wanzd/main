package com.pd.ehr;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
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
    
    public static interface Dao extends IDao<VO, FO>
    {
        
    }
    
    
    public static class DbService implements IDbService<VO, FO, Dao>
    {
        
    }
    
    public static class Test extends EhrTestCase
    {
        
    }
}
