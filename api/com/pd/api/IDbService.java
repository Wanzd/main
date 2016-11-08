package com.pd.api;

public interface IDbService<_V extends DbV, _F extends IFilter, _Dao extends IDa<_V, _F>>
{
    _Dao getDao();
    
    default int c(_V value)
    {
        return getDao().c(value);
    }
    
    default _V r(_F filter)
    {
        return getDao().r(filter);
    }
}
