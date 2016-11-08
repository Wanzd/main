package com.pd.api;

import java.util.List;

public interface IExcelService<VO extends DbV>
{
    void export();
    
    List<VO> imports();
}
