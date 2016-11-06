package com.pd.api;

public class VO implements IValueObject
{
    private Long idxId, flowId;
    
    private String name;
    
    public Long getIdxId()
    {
        return idxId;
    }
    
    public void setIdxId(Long idxId)
    {
        this.idxId = idxId;
    }
    
    public Long getFlowId()
    {
        return flowId;
    }
    
    public void setFlowId(Long flowId)
    {
        this.flowId = flowId;
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
