package com.pd.it.common;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import validRule.java.lang.String.Mail;

import com.pd.it.common.util.AI;

public class AIValidTest
{
    @Test
    public void testValidStringNotNull()
    {
        assertEquals(true, AI.valid("test", String.class, "!Null"));
        assertEquals(false, AI.valid(null, String.class, "!Null"));
    }
    
    @Test
    public void testValidStringIsMail()
    {
        assertEquals(false, AI.valid("11", String.class, "Mail"));
        assertEquals(true, AI.valid("1@1", String.class, "Mail"));
    }
    
    @Test
    public void testValidStringIsNull()
    {
        assertEquals(false, AI.valid("1@1", String.class, "Null"));
        assertEquals(true, AI.valid(null, String.class, "Null"));
    }
    
    @Test
    public void testValidStringMail()
    {
        for (int i = 0; i < 1000000; i++)
        {
            assertEquals(true, AI.valid("1@1", String.class, "Mail"));
            assertEquals(false, AI.valid("111", String.class, "Mail"));
        }
    }
    @Test
    public void testValidStringMail2()
    {
        for (int i = 0; i < 1000000; i++)
        {
            assertEquals(true, AI.valid("1@1", String.class, new Mail()));
            assertEquals(false, AI.valid("111", String.class, new Mail()));
        }
    }
    @Test
    public void testValidStringMail3()
    {
        Mail rule = new Mail();
        for (int i = 0; i < 1000000; i++)
        {
            assertEquals(true, AI.valid("1@1", String.class, rule));
            assertEquals(false, AI.valid("111", String.class, rule));
        }
    }
    @Test
    public void testValidStringComplex()
    {
        assertEquals(true, AI.valid("1@1", String.class, "!Null,Mail"));
    }
    
    @Test
    public void testBuild()
    {
        String build = AI.build("test", String.class, "Cap");
        assertEquals("Test", build);
    }
    
    @Test
    public void testMap()
    {
        Map<String, Object> map = AI.map("a", "aa", "b", "bb");
        assertEquals("aa", map.get("a"));
        assertEquals("bb", map.get("b"));
    }
}
