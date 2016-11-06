package com.pd.api;

import java.util.List;

public class PagedList<T> 
{
    private List<T> list;
    
    private PageVO pageVo;

    public List<T> getList()
    {
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }

    public PageVO getPageVo()
    {
        return pageVo;
    }

    public void setPageVo(PageVO pageVo)
    {
        this.pageVo = pageVo;
    }
}
