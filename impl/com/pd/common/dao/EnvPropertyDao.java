package com.pd.common.dao;

import com.pd.common.dao.IPropertyDao;
import com.pd.common.util.ResultUtil;

public class EnvPropertyDao implements IPropertyDao
{
    
    @Override
    public String getString(String key)
    {
        String rs = System.getenv(key);
        return ResultUtil.trans(rs);
    }
    
}
