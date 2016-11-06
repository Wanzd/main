package com.pd.api;

public interface IDao<VO extends DatabaseVO, FilterVO extends IFilterVO>
{
    int add(VO vo);
    
    int update(VO vo);
    
    int delete(VO vo);
    
    int addOrUpdate(VO vo);
    
    PagedList<VO> pageList(FilterVO filterVO, PageVO pageVO);
}
