package com.pd.it.common.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pd.it.common.itf.IBridge;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ISender;
import com.pd.it.common.itf.ITask;
import com.pd.it.common.itf.IValidRule;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.VO;

public class AI
{
    public static <Out> Out c(Class<Out> outClass, Object... in)
    {
        return ObjectUtil.c(outClass, in);
    }
    
    public static <Out> Out u(Out inOut, Object... in)
    {
        return ObjectUtil.u(inOut, in);
    }
    
    public static BigInteger bigInt(String expression, Map<Object, Object> map)
    {
        return BigMathUtil.bigInt(expression, map);
    }
    
    public static <InOut, Attr> InOut s(InOut inOut, String k, Attr v)
    {
        return ObjectUtil.s(inOut, k, v);
    }
    
    public static <MsgVO, Sender> String send(MsgVO msgVO, ISender<MsgVO> sender)
    {
        return sender.send(msgVO);
    }
    
    public static <In, Out> Out bridge(In in, IBuilder<?, ?>... builders)
    {
        return BuildUtil.bridge(in, builders);
    }
    
    public static <In, Out> Out bridge(In in, IBridge<In, Out> bridge)
    {
        return BuildUtil.bridge(in, bridge);
    }
    
    public static <In, Out> Out build(IBuilder<In, Out> builder, In... in)
    {
        return BuildUtil.build(builder, in);
    }
    
    public static <In> boolean valid(Class<In> inClass, In in, String beansStr)
    {
        return ValidUtil.valid(inClass, in, beansStr);
    }
    
    public static <In> boolean valid(Class<In> inClass, In in, IValidRule<In>... beans)
    {
        return ValidUtil.valid(inClass, in, beans);
    }
    
    public static <In> In nvl(In in, In defaultValue)
    {
        return in != null ? in : defaultValue;
    }
    
    public static <K, V> Map<K, V> map(Map<K, V> map, Object... in)
    {
        if (map == null)
        {
            map = new HashMap<K, V>();
        }
        if (in.length % 2 != 0)
        {
            return map;
        }
        for (int i = 0; i < in.length; i += 2)
        {
            map.put((K)in[i], (V)in[i + 1]);
        }
        return map;
    }
    
    public static <K, V> Map<K, V> map(Object... in)
    {
        
        return map(new HashMap<K, V>(), in);
    }
    
    public static Object js(String string)
    {
        return JsUtil.js(string);
    }
    
    private static ApplicationContext ctx = null;
    
    public static <In> In bean(Class<In> inClass, String beanName)
    {
        if (ctx == null)
        {
            ctx = new ClassPathXmlApplicationContext("cfg/spring-mybatis.xml");
        }
        In bean = (In)ctx.getBean(beanName);
        return bean;
    }
    
    public static void execute(ITask task)
    {
        List<ITask> subList = task.sub();
        if (subList != null)
        {
            for (ITask itTask : subList)
            {
                itTask.execute();
            }
        }
        else
        {
            task.execute();
        }
    }
    
    public static KV kv(String... kvStr)
    {
        KV kv = new KV();
        for (int i = 0, total = kvStr.length; i < total; i += 2)
        {
            kv.put(kvStr[i], kvStr[i + 1]);
        }
        return kv;
    }
    
    public static <In> List<In> list(In... in)
    {
        List<In> rsList = new ArrayList<In>();
        for (In eachIn : in)
        {
            rsList.add(eachIn);
        }
        return rsList;
    }
}
