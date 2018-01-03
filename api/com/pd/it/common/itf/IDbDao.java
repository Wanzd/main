package com.pd.it.common.itf;

import java.util.List;

public interface IDbDao<VO, FO extends VO>
{
    // @SelectProvider(method = "c", type = AiSqlProvider.class)
    Integer c(VO vo);
    
    VO r(FO fo);
    
    int u(VO vo);
    
    // @SelectProvider(method = "d", type = AiSqlProvider.class)
    int d(VO vo);
    
    int ds(List<VO> vo);
    
    List<VO> ra();
    
    List<VO> rs(FO fo);
    
}
