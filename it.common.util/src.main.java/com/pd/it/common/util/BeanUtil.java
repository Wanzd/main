package com.pd.it.common.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.itf.IValidRule;

public class BeanUtil
{
    private static SqlSession sqlSession;
    
    public static <Out> Out getBean(String name)
    {
        WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
        SqlSessionFactory sqlFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
        sqlSession = sqlFactory.openSession();
        try
        {
            Out outBean = (Out)sqlSession.getMapper(Class.forName(name));
            return outBean;
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    /** ͨ�������ҵ�ָ�����͵�builder */
    public static <In, Out> IBuilder<In, Out> getBuilder(Class<Out> outClass, String builderBean)
    {
        String className = "builder." + outClass.getName() + "." + builderBean;
        try
        {
            Class<?> forName = Class.forName(className);
            Object newInstance = forName.newInstance();
            if (newInstance instanceof IBuilder)
            {
                return (IBuilder<In, Out>)newInstance;
            }
        }
        catch (Exception e)
        {
            LogUtil.err(e);
        }
        return null;
    }
    
    public static <In> IValidRule<In> getValidRule(Class<In> inClass, String bean)
    {
        String className = "validRule." + inClass.getName() + "." + bean;
        try
        {
            Class<?> forName = Class.forName(className);
            Object newInstance = forName.newInstance();
            if (newInstance instanceof IValidRule)
            {
                return (IValidRule<In>)newInstance;
            }
        }
        catch (Exception e)
        {
            LogUtil.err(e);
        }
        return null;
    }
}
