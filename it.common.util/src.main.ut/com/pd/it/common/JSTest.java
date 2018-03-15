package com.pd.it.common;

import javax.script.ScriptException;

import org.junit.Test;

import com.pd.it.common.util.AI;

public class JSTest
{
    @Test
    public void testJSByStr()
        throws ScriptException
    {
        Object rs = AI.js("print('hello,js')");
        System.out.println(rs);
    }
}
