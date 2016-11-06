package com.pd.api;

import java.util.List;

public interface IBaseService<Vo extends DbVO, Fo extends IFo, Dao extends IBaseDao<Vo, Fo>>
{
    IBaseDao<Vo, Fo> getDao();
    
    default PagedList<Vo> pagedList(Fo filterVO, PageVO pageVO)
    {
        return getDao().pagedList(filterVO, pageVO);
    };
    
    default List<Vo> listAll(Fo filterVO)
    {
        return getDao().listAll(filterVO);
    };
}
