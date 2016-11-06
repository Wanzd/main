package com.pd.api;

public interface IDbService<_Vo extends DbVO, _Fo extends IFo, _Dao extends IDao<_Vo, _Fo>>
{
    _Dao getDao();
    
    default int add(_Vo vo)
    {
        return getDao().add(vo);
    }
}
