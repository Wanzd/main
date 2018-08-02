package com.pd.it.common.vo;

public class ResultVO extends VO
{
    
    private static final long serialVersionUID = -143398554658907794L;
    
    public static enum Status
    {
        Success, Fail, Error
    }
    
    private ResultVO(Status status, String msg, String code)
    {
        super();
        put("msg", msg);
        put("status", status);
        put("code", code);
    }
    
    public static ResultVO success(String msg)
    {
        // TODO Auto-generated method stub
        return new ResultVO(Status.Success, msg, "200");
    }
    
}
