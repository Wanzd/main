package com.pd.ehr.core.itf;

import java.util.List;

import com.pd.ehr.core.vo.EhrBaseVO;

public interface IEhrExcelService<VO extends EhrBaseVO>
{
    void export();
    
    List<VO> imports();
}
