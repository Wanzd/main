package com.pd.it.common.itf;

import com.pd.it.db.DbVO;

public interface ITreeService
{
    String root(DbVO vo);
    
    String sub(DbVO vo);
    
}