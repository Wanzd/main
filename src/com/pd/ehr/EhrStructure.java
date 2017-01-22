package com.pd.ehr;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;

public class EhrStructure
{
    public static interface IDbAtom<_Vo extends EhrDataBaseVO, _Fo extends IEhrFilterVO, _Dao extends IDao<_Vo, _Fo>, _Service extends IDbService<_Vo, _Fo, _Dao>>
    {
        
    }
    
    public static abstract class DbAtom<_Vo extends EhrDataBaseVO, _Fo extends IEhrFilterVO, _Dao extends IDao<_Vo, _Fo>, _Service extends IDbService<_Vo, _Fo, _Dao>>
        implements IDbAtom<_Vo, _Fo, _Dao, _Service>
    {
        
    }
}
