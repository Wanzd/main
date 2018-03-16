package com.pd.it.db;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.itf.IDbTreeDao;
import com.pd.it.common.vo.VO;

public class TreeDaoUtil
{
    private static Map<String, IDbTreeDao> daoKV = null;
    
    private static SqlSession sqlSession;
    
    /**
     * 初始化dao反射
     */
    public static void initDaoKv()
    {
        try
        {
            daoKV = new HashMap<String, IDbTreeDao>();
            WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
            SqlSessionFactory sqlFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
            sqlSession = sqlFactory.openSession();
            daoKV.put("menu", (IDbTreeDao)sqlSession.getMapper(Class.forName("com.pd.it.menu$tree.IMenuTreeDao")));
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static IDbTreeDao get(String key)
    {
        if (daoKV == null)
        {
            daoKV = new HashMap<String, IDbTreeDao>();
            synchronized (daoKV)
            {
                initDaoKv();
            }
        }
        return daoKV.get(key);
    }
}
