package com.pd.ehr.ip.util;

import com.pd.ehr.ip.impl.IpChannel;

public class IpUtil
{
    
    public static String getCurW3Ip()
    {
        return IpChannel.Ip138.build(null).getIp();
    }
    
}
