package com.pd.api;

public class DatabaseVO extends VO
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
