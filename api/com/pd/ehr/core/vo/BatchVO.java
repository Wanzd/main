package com.pd.ehr.core.vo;

import java.util.List;

public class BatchVO<VO extends EhrDBVO>
{
    private List<VO> addList;
    
    private List<VO> updateList;
    
    private List<VO> delList;
    
    public List<VO> getAddList()
    {
        return addList;
    }
    
    public void setAddList(List<VO> addList)
    {
        this.addList = addList;
    }
    
    public List<VO> getUpdateList()
    {
        return updateList;
    }
    
    public void setUpdateList(List<VO> updateList)
    {
        this.updateList = updateList;
    }
    
    public List<VO> getDelList()
    {
        return delList;
    }
    
    public void setDelList(List<VO> delList)
    {
        this.delList = delList;
    }
}
