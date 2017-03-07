package com.pd.ehr.quark.javascript;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.junit.Test;

public class JSTest
{
    @Test
    public void testJSByStr()
        throws ScriptException
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval("print('hello,js')");
        
    }
    
    @Test
    public void testJSByFile()
        throws ScriptException, FileNotFoundException
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(new FileReader("src.quark.script/com/pd/ehr/quark/javascript/test.js"));
        
    }
    
    @Test
    public void testJSUseJavaObject()
        throws ScriptException, FileNotFoundException
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        File f = new File("src.quark.script/com/pd/ehr/quark/javascript/test.js");
        engine.put("curFile", f);
        engine.eval("print(curFile.getAbsolutePath());");
        
    }
    
    @Test
    public void testJSUseJsFunction()
        throws ScriptException, FileNotFoundException, NoSuchMethodException
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval(new FileReader("src.quark.script/com/pd/ehr/quark/javascript/ehr.js"));
        for (int i = 0, total = 5; i++ < total;)
        {
            engine.eval("ehr.out('testJSUseJsFunction" + i + "');");
        }
    }
    
    @Test
    public void testJSImplJavaApi()
        throws ScriptException, FileNotFoundException, NoSuchMethodException
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval("function run(){print('runImpl');}");
        Invocable inv = (Invocable)engine;
        Runnable r = inv.getInterface(Runnable.class);
        Thread th = new Thread(r);
        th.start();
    }
    
    @Test
    public void testJSObjImplJavaApi()
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try
        {
            engine.eval(new FileReader("src.quark.script/com/pd/ehr/quark/javascript/ehr.js"));
        }
        catch (FileNotFoundException | ScriptException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Object obj = engine.get("ehr");
        Invocable inv = (Invocable)engine;
        Runnable r = inv.getInterface(obj, Runnable.class);
        Thread th = new Thread(r);
        th.start();
    }
    
    @Test
    public void testJSScope()
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try
        {
            engine.eval(new FileReader("src.quark.script/com/pd/ehr/quark/javascript/ehr.js"));
            engine.eval("print(ehr);");
            engine.put("ehr", "hello");
            engine.eval("print(ehr);");
            ScriptContext newContext = new SimpleScriptContext();
            Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
            engineScope.put("ehr", "engine_scope:ehr");
            engine.eval("print(ehr);", engineScope);
        }
        catch (FileNotFoundException | ScriptException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testJSExtendsJavaApi()
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try
        {
            engine.eval(new FileReader("src.quark.script/com/pd/ehr/quark/javascript/testJSExtendsJavaApi.js"));
        }
        catch (FileNotFoundException | ScriptException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void testJSImportJava()
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try
        {
            engine.eval(new FileReader("src.quark.script/com/pd/ehr/quark/javascript/testJSImportJava.js"));
        }
        catch (FileNotFoundException | ScriptException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
