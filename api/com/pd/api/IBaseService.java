package com.pd.api;

import java.util.List;

public interface IBaseService<VO extends DatabaseVO, FilterVO extends IFilterVO>
{
    IBaseDao getDao();
    
    default List<VO> list(FilterVO filterVO, PageVO pageVO)
    {
        return getDao().pagedList(filterVO, pageVO);
    };
}
