package com.pd.common.util;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class WebUtilTest
{
    
    @Test
    public void testGetAddressByIp()
    {
        String getAddressByIp = WebUtil.GetAddressByIp("61.136.167.33");
        ViewUtil.view(getAddressByIp);
        assertEquals("中国--华中--十堰市--电信", getAddressByIp);
    }
    
    @BeforeClass
    public static void setup()
    {
        LogUtil.setDetailMode(true);
    }
}
