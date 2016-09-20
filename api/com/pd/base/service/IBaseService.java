package com.pd.base.service;

import java.util.List;

import com.pd.base.dao.IBaseDao;
import com.pd.ehr.core.vo.EhrBaseVO;
import com.pd.ehr.core.vo.EhrPageVO;
import com.pd.ehr.core.vo.IEhrFilterVO;

public interface IBaseService<VO extends EhrBaseVO, FilterVO extends IEhrFilterVO>
{
    IBaseDao getDao();
    
    default List<VO> list(FilterVO filterVO, EhrPageVO pageVO)
    {
        return getDao().pagedList(filterVO, pageVO);
    };
}
