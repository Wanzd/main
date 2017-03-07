package com.pd.ehr.ip;

import com.pd.ehr.util.EhrTestCase;
import com.pd.ehr.util.Show;

public class IpTest extends EhrTestCase
{
    public void testGetSelfPublicIp()
    {
        String curW3Ip = IpUtil.getCurW3Ip();
        Show.ln(curW3Ip);
    }
}