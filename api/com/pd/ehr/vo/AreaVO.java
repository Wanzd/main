package com.pd.ehr.vo;

public class AreaVO<T>
{
    private T start;
    
    private T end;
    
    public T getStart()
    {
        return start;
    }
    
    public void setStart(T start)
    {
        this.start = start;
    }
    
    public T getEnd()
    {
        return end;
    }
    
    public void setEnd(T end)
    {
        this.end = end;
    }
}
