package com.pd.api;

public class VO
{
    private long idxId, flowId;
    
    private String name;
    
    public void setFlowId(long flowId)
    {
        this.flowId = flowId;
    }
    
    public long getFlowId()
    {
        return flowId;
    }
    
    public void setIdxId(long idxId)
    {
        this.idxId = idxId;
    }
    
    public long getIdxId()
    {
        return idxId;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
