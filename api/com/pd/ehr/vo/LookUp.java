package com.pd.ehr.vo;

import com.pd.api.VO;

public class LookUp extends VO
{
    private LookUp parent;
    
    private String itemCode;
    
    private String itemName;
    
    private String language;
    
    private String detail;
    
    private String attr1;
    
    private String attr2;
    
    private String attr3;
    
    private String attr4;
    
    private String attr5;
    
    public LookUp getParent()
    {
        return parent;
    }
    
    public void setParent(LookUp parent)
    {
        this.parent = parent;
    }
    
    public String getItemCode()
    {
        return itemCode;
    }
    
    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    
    public String getLanguage()
    {
        return language;
    }
    
    public void setLanguage(String language)
    {
        this.language = language;
    }
    
    public String getDetail()
    {
        return detail;
    }
    
    public void setDetail(String detail)
    {
        this.detail = detail;
    }
    
    public String getAttr1()
    {
        return attr1;
    }
    
    public void setAttr1(String attr1)
    {
        this.attr1 = attr1;
    }
    
    public String getAttr2()
    {
        return attr2;
    }
    
    public void setAttr2(String attr2)
    {
        this.attr2 = attr2;
    }
    
    public String getAttr3()
    {
        return attr3;
    }
    
    public void setAttr3(String attr3)
    {
        this.attr3 = attr3;
    }
    
    public String getAttr4()
    {
        return attr4;
    }
    
    public void setAttr4(String attr4)
    {
        this.attr4 = attr4;
    }
    
    public String getAttr5()
    {
        return attr5;
    }
    
    public void setAttr5(String attr5)
    {
        this.attr5 = attr5;
    }
}
