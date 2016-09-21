package com.pd.api;

import java.util.List;

import com.pd.ehr.vo.DatabaseVO;

public interface IEhrExcelService<VO extends DatabaseVO>
{
    void export();
    
    List<VO> imports();
}
