package com.pd.it.common;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import validRule.java.lang.String.Mail;

import com.pd.it.common.util.AI;

public class AIBuildTest
{
    @Test
    public void testBuildStringCap()
    {
        assertEquals("Test", AI.build("test", String.class, "Cap"));
    }
}
