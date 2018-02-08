package com.pd.it.common.vo;

import java.util.List;

public class BatchList<Vo>
{
    private List<Vo> cList;
    
    private List<Vo> uList;
    
    private List<Vo> dList;
    
    public List<Vo> getcList()
    {
        return cList;
    }
    
    public void setcList(List<Vo> cList)
    {
        this.cList = cList;
    }
    
    public List<Vo> getuList()
    {
        return uList;
    }
    
    public void setuList(List<Vo> uList)
    {
        this.uList = uList;
    }
    
    public List<Vo> getdList()
    {
        return dList;
    }
    
    public void setdList(List<Vo> dList)
    {
        this.dList = dList;
    }
}
