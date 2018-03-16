package com.pd.it.lookup;

public class LookupDto extends LookupVO
{
    private String typeCn;
    
    public String getTypeCn()
    {
        if (typeCn == null)
        {
            typeCn = type.getCn();
        }
        return typeCn;
    }
    
    public void setTypeCn(String typeCn)
    {
    }
}
