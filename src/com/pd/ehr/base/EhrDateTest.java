package com.pd.ehr.base;

import org.junit.Test;

import com.pd.ehr.EhrDate;
import com.pd.ehr.EhrDateApi.IEhrDateTest;

public class EhrDateTest implements IEhrDateTest
{
    
    @Test
    @Override
    public void testGetNow()
    {
        System.out.println(EhrDate.getNow());
    }
}
