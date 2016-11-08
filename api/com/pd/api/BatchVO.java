package com.pd.api;

import java.util.List;

public class BatchVO<_VO extends DbV>
{
    private List<_VO> addList;

    private List<_VO> updateList;
    
    private List<_VO> delList;
    
    public List<_VO> getAddList()
    {
        return addList;
    }

    public void setAddList(List<_VO> addList)
    {
        this.addList = addList;
    }

    public List<_VO> getUpdateList()
    {
        return updateList;
    }

    public void setUpdateList(List<_VO> updateList)
    {
        this.updateList = updateList;
    }

    public List<_VO> getDelList()
    {
        return delList;
    }

    public void setDelList(List<_VO> delList)
    {
        this.delList = delList;
    }
}
