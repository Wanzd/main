package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.db.DbVO;

public interface IDbTreeDao
{
    List<DbVO> root(DbVO fo);
    
    List<DbVO> sub(DbVO fo);
    
}
