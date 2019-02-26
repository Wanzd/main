package com.pd.it.common.itf;

import com.pd.it.common.vo.VO;

public interface ITreeService
{
    String root(VO vo);
    
    String sub(VO vo);
    
}