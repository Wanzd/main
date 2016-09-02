package com.pd.ehr.core.itf;

import com.pd.ehr.core.collection.PagedList;
import com.pd.ehr.core.vo.EhrBaseVO;
import com.pd.ehr.core.vo.IEhrFilterVO;
import com.pd.ehr.core.vo.PageVO;

public interface IEhrBaseDao<VO extends EhrBaseVO, FilterVO extends IEhrFilterVO>
{
    int add(VO vo);
    
    int update(VO vo);
    
    int delete(VO vo);
    
    int addOrUpdate(VO vo);
    
    PagedList<VO> pageList(FilterVO filterVO, PageVO pageVO);
}
