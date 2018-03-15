package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.BatchList;

public interface IBatchService<VO>
{
    
    String cs(List<VO> list);
    
    String ra();
    
    String rs(VO fo);
    
    String ds(List<VO> list);
    
    String us(List<VO> list);
    
    String batch(BatchList<VO> vo);
}
