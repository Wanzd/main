package com.pd.ehr.util;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.Base.IFilterVO;
import com.pd.base.EhrApi.Db.IDao;
import com.pd.base.EhrApi.Db.IDbService;

public class EhrStructure
{
    public static interface IDbAtom<_Vo extends EhrDataBaseVO, _Fo extends IFilterVO, _Dao extends IDao<_Vo, _Fo>, _Service extends IDbService<_Vo, _Fo, _Dao>>
    {
        
    }
    
    public static abstract class DbAtom<_Vo extends EhrDataBaseVO, _Fo extends IFilterVO, _Dao extends IDao<_Vo, _Fo>, _Service extends IDbService<_Vo, _Fo, _Dao>>
        implements IDbAtom<_Vo, _Fo, _Dao, _Service>
    {
        
    }
}
