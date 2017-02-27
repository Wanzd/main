package com.pd.ehr.ip.vo;

import com.pd.base.Base.EhrDataBaseVO;

public class IpVo extends EhrDataBaseVO
{
    private String ip;
    
    public String getIp()
    {
        return ip;
    }
    
    public IpVo setIp(String ip)
    {
        this.ip = ip;
        return this;
    }
    
}