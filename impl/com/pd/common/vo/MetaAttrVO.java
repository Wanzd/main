package com.pd.common.vo;

public class MetaAttrVO
{
    private String name;
    
    private String type;
    
    public MetaAttrVO(String name, String type)
    {
        super();
        this.name = name;
        this.type = type;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getType()
    {
        return type;
    }
    
}
