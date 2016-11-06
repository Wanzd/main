package com.pd.api;

import com.pd.ehr.vo.DatabaseVO;

@SuppressWarnings("hiding")
public interface IDatabaseService<VO extends DatabaseVO, FO extends IFilterVO, Dao extends IDao<VO, FO>>
{
    Dao getDao();
    
    default int add(VO vo)
    {
        return getDao().add(vo);
    }
}
