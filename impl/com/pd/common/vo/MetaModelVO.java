package com.pd.common.vo;

import java.util.List;

public class MetaModelVO
{
    private String name;
    
    private List<MetaAttrVO> attrList;
    
    public MetaModelVO(String name, List<MetaAttrVO> attrList)
    {
        super();
        this.name = name;
        this.attrList = attrList;
    }
    
    public String getName()
    {
        return name;
    }
    
    public List<MetaAttrVO> getAttrList()
    {
        return attrList;
    }
    
    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for (MetaAttrVO attr : attrList)
        {
            sb.append("," + attr);
        }
        sb.delete(0, 1);
        return String.format("%s[%s]", name, sb);
    }
    
}
