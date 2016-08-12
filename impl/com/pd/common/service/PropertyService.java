package com.pd.common.service;

import com.pd.common.dao.IPropertyDao;
import com.pd.common.dao.PropertyDao;

public class PropertyService implements IPropertyService
{
    private IPropertyDao dao;
    public PropertyService(String project){
        dao=new PropertyDao(project);
    }
    @Override
    public String value(String key)
    {
        return dao.getString(key);
    }
    
}
