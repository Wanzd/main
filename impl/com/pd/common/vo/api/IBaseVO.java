package com.pd.common.vo.api;

import java.util.Map;

import com.pd.common.vo.impl.Attribute;

public interface IBaseVO
{
    Map<String, Attribute> atts();
    
    Attribute att(String name);
    
    String str(String name);
}
