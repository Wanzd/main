package com.pd.api;

import com.pd.ehr.vo.DatabaseVO;
import com.pd.ehr.vo.IEhrFilterVO;
import com.pd.ehr.vo.PageVO;
import com.pd.ehr.vo.PagedList;

public interface IDao<VO extends DatabaseVO, FilterVO extends IEhrFilterVO>
{
    int add(VO vo);
    
    int update(VO vo);
    
    int delete(VO vo);
    
    int addOrUpdate(VO vo);
    
    PagedList<VO> pageList(FilterVO filterVO, PageVO pageVO);
}
