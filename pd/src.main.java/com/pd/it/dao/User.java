package com.pd.it.dao;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.itf.IDbTreeDao;

public class User
{
    @Repository
    public static interface IUserDao extends IDbDao
    {
        
    }
    
    @Repository
    public static interface IUserTreeDao extends IDbTreeDao
    {
        
    }
    
}
