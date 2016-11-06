package com.pd.api;

import java.util.List;

public class BatchVO<Vo extends DatabaseVO>
{
    private List<Vo> addList;
    
    private List<Vo> updateList;
    
    private List<Vo> delList;
    
    public List<Vo> getAddList()
    {
        return addList;
    }
    
    public void setAddList(List<Vo> addList)
    {
        this.addList = addList;
    }
    
    public List<Vo> getUpdateList()
    {
        return updateList;
    }
    
    public void setUpdateList(List<Vo> updateList)
    {
        this.updateList = updateList;
    }
    
    public List<Vo> getDelList()
    {
        return delList;
    }
    
    public void setDelList(List<Vo> delList)
    {
        this.delList = delList;
    }
}
