package com.pd.it.common.abs;

import java.util.List;

import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.itf.IDbService;

public abstract class AbsDbService<Vo, Fo extends Vo> implements IDbService<Vo, Fo>
{
    
    abstract IDbDao<Vo, Fo> getDao();
    
    @Override
    public int c(Vo vo)
    {
        return getDao().c(vo);
    }
    
    @Override
    public Vo r(Fo fo)
    {
        return getDao().r(fo);
    }
    
    @Override
    public int d(Vo vo)
    {
        return getDao().d(vo);
    }
    
    @Override
    public int u(Vo vo)
    {
        return getDao().u(vo);
    }
    
    
    @Override
    public List<Vo> rs(Fo fo)
    {
        return getDao().rs(fo);
    }
    
    @Override
    public int ds(List<Vo> list)
    {
        return getDao().ds(list);
    }
    
}
