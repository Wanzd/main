package com.pd.it.common.vo;

public class PageVO
{
    private int totalCount, totalPage, pageNo, pageSize = 1, start, end;
    
    public int getTotalCount()
    {
        return totalCount;
    }
    
    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
        cal();
    }
    
    public int getTotalPage()
    {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }
    
    public int getPageNo()
    {
        return pageNo;
    }
    
    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
        cal();
    }
    
    public int getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
        cal();
    }
    
    public int getStart()
    {
        return start;
    }
    
    public void setStart(int start)
    {
        this.start = start;
    }
    
    public int getEnd()
    {
        return end;
    }
    
    public void setEnd(int end)
    {
        this.end = end;
    }
    
    private void cal()
    {
        if (totalCount == 0)
        {
            start = (pageNo - 1) * pageSize + 1;
            end = pageNo * pageSize;
        }
        else
        {
            start = (pageNo - 1) * pageSize + 1;
            end = Math.min(end, pageNo * pageSize);
            totalPage = totalCount / pageSize;
        }
    }
}
