package com.pd.ehr.core.service;

import com.pd.ehr.core.itf.IEhrCommonService;

public abstract class EhrCommonService implements IEhrCommonService
{
    private String name;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
