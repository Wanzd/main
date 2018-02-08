package com.pd.it.common.vo;

public class RsVO
{
    private String errorMsg;
    
    private String msg;
    
    public RsVO(Status status, String msg, String errorMsg)
    {
        this.status = status;
        this.msg = msg;
        this.errorMsg = errorMsg;
    }
    
    public String getMsg()
    {
        return msg;
    }
    
    public void setMsg(String msg)
    {
        this.msg = msg;
    }
    
    private Status status;
    
    public String getErrorMsg()
    {
        return errorMsg;
    }
    
    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
    
    public Status getStatus()
    {
        return status;
    }
    
    public void setStatus(Status status)
    {
        this.status = status;
    }
    
    public static enum Status
    {
        SUCCESS, ERROR, FAIL
    }
}
