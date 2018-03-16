package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.VO;

public interface IDbTreeDao
{
    List<VO> root(VO fo);
    
    List<VO> sub(VO fo);
    
}
