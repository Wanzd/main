package com.pd.ehr.core.vo;

public class EhrDBVO extends EhrBaseVO
{
    
    private String createrId, createTime, lastModifyTime, lastModifyId;
    
    public String getCreaterId()
    {
        return createrId;
    }
    
    public void setCreaterId(String createrId)
    {
        this.createrId = createrId;
    }
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public String getLastModifyTime()
    {
        return lastModifyTime;
    }
    
    public void setLastModifyTime(String lastModifyTime)
    {
        this.lastModifyTime = lastModifyTime;
    }
    
    public String getLastModifyId()
    {
        return lastModifyId;
    }
    
    public void setLastModifyId(String lastModifyId)
    {
        this.lastModifyId = lastModifyId;
    }
    
}
