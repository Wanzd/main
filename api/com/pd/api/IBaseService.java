package com.pd.api;

import java.util.List;

import com.pd.ehr.vo.DatabaseVO;
import com.pd.ehr.vo.EhrPageVO;
import com.pd.ehr.vo.IEhrFilterVO;

public interface IBaseService<VO extends DatabaseVO, FilterVO extends IEhrFilterVO>
{
    IBaseDao getDao();
    
    default List<VO> list(FilterVO filterVO, EhrPageVO pageVO)
    {
        return getDao().pagedList(filterVO, pageVO);
    };
}
