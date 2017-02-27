package com.pd.ehr.ip;

public class IpUtil
{
    
    public static String getCurW3Ip()
    {
        return IpChannel.Ip138.build(null).getIp();
    }
    
}
