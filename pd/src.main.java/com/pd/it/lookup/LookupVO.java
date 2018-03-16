package com.pd.it.lookup;

import com.pd.it.lookup$type.LookupTypeVO;

public class LookupVO extends LookupTypeVO
{
    protected LookupTypeVO type;
    
    public LookupTypeVO getType()
    {
        return type;
    }
    
    public void setType(LookupTypeVO type)
    {
        this.type = type;
    }
    
    public String getTypeId()
    {
        return type.getId();
    }
    
    public void setTypeId(String typeId)
    {
        type.setId(typeId);
    }
}
