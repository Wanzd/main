package com.pd.api;

import java.util.List;

import com.pd.api.annotation.Dao;

@Dao
public interface ITreeDao<_V extends DbV, _F extends IFilter> 
{
    @DaoApi
    List<_V> root();
    
    @DaoApi
    List<_V> sub(_F fo);
}
