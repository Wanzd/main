package com.pd.api;

@SuppressWarnings("hiding")
public interface IDatabaseService<Vo extends DatabaseVO, Fo extends IFilterVO, Dao extends IDao<Vo, Fo>>
{
    Dao getDao();
    
    default int add(Vo vo)
    {
        return getDao().add(vo);
    }
}
