package com.pd.common.vo;


public class RoleVO
{
    // ReadAll, ReadSelf, CreateTable, CreateData, UpdataAll, UpdataSelf, DeleteAll, DeleteSelf
    private String name;
    
    public RoleVO(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}
