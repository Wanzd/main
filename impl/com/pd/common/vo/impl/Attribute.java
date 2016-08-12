package com.pd.common.vo.impl;

public class Attribute
{
    private String name;
    
    private AttType type;
    
    private Object value;
    
    public Attribute(String name, AttType type, Object value)
    {
        this.name = name;
        this.type = type;
        this.value = value;
    }
    
    public Object v()
    {
        return value;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s[%s:%s]", name, type, value);
    }
}
