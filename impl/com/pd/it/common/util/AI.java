package com.pd.it.common.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pd.it.common.itf.IBridge;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ISender;
import com.pd.it.common.itf.IValidRule;

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
    
    public static <InOut, Attr> InOut s(InOut inOut, String k, Attr v)
    {
       return ObjectUtil.s(inOut, k, v);
    }
    
    public static <MsgVO, Sender> String send(MsgVO msgVO, ISender<MsgVO> sender)
    {
        return sender.send(msgVO);
    }
    
    /** 对入参in进行builders的遍历处理得到out */
    public static <In, Out> Out bridge(In in, IBuilder<?, ?>... builders)
    {
        return BuildUtil.bridge(in, builders);
    }
    
    /** 对入参in 进行bridge处理得到out */
    public static <In, Out> Out bridge(In in, IBridge<In, Out> bridge)
    {
        return BuildUtil.bridge(in, bridge);
    }
    
    public static <In, Out> Out build(In in, Class<Out> outClass, IBuilder<In, Out> builder)
    {
        return BuildUtil.build(in, outClass, builder);
    }
    
    public static <In, Out> Out build(In in, Class<Out> outClass, String builderBean)
    {
        return BuildUtil.build(in, outClass, builderBean);
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
    
    public static Map<String, Object> map(Object... in)
    {
        Map<String, Object> outMap = new HashMap<String, Object>();
        if (in.length % 2 != 0)
        {
            return outMap;
        }
        for (int i = 0; i < in.length; i += 2)
        {
            outMap.put(in[i].toString(), in[i + 1]);
        }
        return outMap;
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
}
