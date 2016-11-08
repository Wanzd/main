package com.pd.api;

/**
 * 
 * Value
 * @author  姓名 工号
 * @version  [版本号, 2016年11月7日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class V implements IValue
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
