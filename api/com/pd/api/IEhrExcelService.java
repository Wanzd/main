package com.pd.api;

import java.util.List;

public interface IEhrExcelService<VO extends DbVO>
{
    void export();
    
    List<VO> imports();
}
