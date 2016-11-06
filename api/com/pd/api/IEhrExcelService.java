package com.pd.api;

import java.util.List;

public interface IEhrExcelService<VO extends DatabaseVO>
{
    void export();
    
    List<VO> imports();
}
