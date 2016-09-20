package com.pd.ehr.base.service;

import com.pd.ehr.core.collection.PagedList;
import com.pd.ehr.core.itf.IEhrDatabaseService;
import com.pd.ehr.core.vo.EhrBaseVO;
import com.pd.ehr.core.vo.IEhrFilterVO;
import com.pd.ehr.core.vo.PageVO;

public abstract class EhrBaseDatabaseService implements IEhrDatabaseService
{
    
    @Override
    public int add(EhrBaseVO vo)
    {
        return getDao().add(vo);
    }
    
    @Override
    public int update(EhrBaseVO vo)
    {
        return getDao().update(vo);
    }
    
    @Override
    public int delete(EhrBaseVO vo)
    {
        return getDao().delete(vo);
    }
    
    @Override
    public int addOrUpdate(EhrBaseVO vo)
    {
        return getDao().addOrUpdate(vo);
    }
    
    @Override
    public PagedList pageList(IEhrFilterVO filterVO, PageVO pageVO)
    {
        return getDao().pageList(filterVO, pageVO);
    }
    
}
