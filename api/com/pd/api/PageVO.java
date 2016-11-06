package com.pd.api;

public class PageVO
{
    private int totalCount;
    
    private int pageSize;
    
    private int pageCount;
    
    private int curPage;
    
    private int startIdx;
    
    private int endIdx;
    
    public int getStartIdx()
    {
        return startIdx;
    }
    
    public void setStartIdx(int startIdx)
    {
        this.startIdx = startIdx;
    }
    
    public int getEndIdx()
    {
        return endIdx;
    }
    
    public void setEndIdx(int endIdx)
    {
        this.endIdx = endIdx;
    }
    
    public int getTotalCount()
    {
        return totalCount;
    }
    
    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }
    
    public int getPageCount()
    {
        return pageCount;
    }
    
    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }
    
    public int getCurPage()
    {
        return curPage;
    }
    
    public void setCurPage(int curPage)
    {
        this.curPage = curPage;
    }
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public int getPageSize()
    {
        return pageSize;
    }
}
