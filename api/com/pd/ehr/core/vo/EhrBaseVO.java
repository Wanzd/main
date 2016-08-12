package com.pd.ehr.core.vo;

public class EhrBaseVO
{
    private long idxId, flowId;
    
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
}
