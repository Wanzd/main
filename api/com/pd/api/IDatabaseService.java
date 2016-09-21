package com.pd.api;

import com.pd.ehr.vo.DatabaseVO;
import com.pd.ehr.vo.IEhrFilterVO;

@SuppressWarnings("hiding")
public interface IDatabaseService<VO extends DatabaseVO, FO extends IEhrFilterVO, Dao extends IDao<VO, FO>>
{
    Dao getDao();
    
    default int add(VO vo)
    {
        return getDao().add(vo);
    }
}
