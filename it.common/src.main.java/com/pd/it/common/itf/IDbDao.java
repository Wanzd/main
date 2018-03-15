package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.PageList;
import com.pd.it.common.vo.PageVO;
import com.pd.it.db.DbVO;

public interface IDbDao
{
    // @SelectProvider(method = "c", type = AiSqlProvider.class)
    int c(DbVO vo);
    
    int cs(List<DbVO> vo);
    
    DbVO r(DbVO fo);
    
    int u(DbVO vo);
    
    // @SelectProvider(method = "d", type = AiSqlProvider.class)
    int d(DbVO vo);
    
    int ds(List<DbVO> vo);
    
    List<DbVO> ra();
    
    List<DbVO> rs(DbVO fo);
    
    int pCount(DbVO fo, PageVO page);
    
    PageList<DbVO> p(DbVO fo);
    
}
