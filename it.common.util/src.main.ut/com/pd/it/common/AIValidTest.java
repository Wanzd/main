package com.pd.it.common;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.pd.it.common.util.AI;

public class AIValidTest
{
    @Test
    public void testValidStringNotNull()
    {
        assertEquals(true, AI.valid(String.class, "test", "!Null"));
        assertEquals(false, AI.valid(String.class, null, "!Null"));
    }
    
    @Test
    public void testValidStringIsMail()
    {
        assertEquals(false, AI.valid(String.class, "11", "Mail"));
        assertEquals(true, AI.valid(String.class, "1@1", "Mail"));
    }
    
    @Test
    public void testValidStringIsNull()
    {
        assertEquals(false, AI.valid(String.class, "1@1", "Null"));
        assertEquals(true, AI.valid(String.class, null, "Null"));
    }
    
    @Test
    public void testValidStringMail()
    {
        for (int i = 0; i < 1000000; i++)
        {
            assertEquals(true, AI.valid(String.class, "1@1", "Mail"));
            assertEquals(false, AI.valid(String.class, "111", "Mail"));
        }
    }
    
    @Test
    public void testValidStringComplex()
    {
        assertEquals(true, AI.valid(String.class, "1@1", "!Null,Mail"));
    }
    
    @Test
    public void testBuild()
    {
    }
    
    @Test
    public void testMap()
    {
        Map<String, Object> map = AI.map("a", "aa", "b", "bb");
        assertEquals("aa", map.get("a"));
        assertEquals("bb", map.get("b"));
    }
}
