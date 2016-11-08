package com.pd.api;

import java.util.List;

public class PageList<T>
{
    private List<T> list;
    
    private PageV pageV;
    
    public List<T> getList()
    {
        return list;
    }
    
    public void setList(List<T> list)
    {
        this.list = list;
    }
    
    public PageV getPageV()
    {
        return pageV;
    }
    
    public void setPageV(PageV pageV)
    {
        this.pageV = pageV;
    }
    
}
