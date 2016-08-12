package com.pd.base.service;

import java.util.List;

import com.pd.ehr.core.vo.EhrBaseVO;
import com.pd.ehr.core.vo.ItfFilterVO;
import com.pd.ehr.core.vo.PageVO;

public interface IBaseService<VO extends EhrBaseVO, FilterVO extends ItfFilterVO>
{
    List<VO> list(FilterVO filterVO, PageVO pageVO);
}
