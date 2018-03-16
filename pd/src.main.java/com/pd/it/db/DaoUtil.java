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

public class DaoUtil
{
    private static Map<String, IDbDao> daoKV = null;
    
    private static SqlSession sqlSession;
    
    /**
     * 初始化dao反射
     */
    public static void initDaoKv()
    {
        try
        {
            daoKV = new HashMap<String, IDbDao>();
            WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
            SqlSessionFactory sqlFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
            sqlSession = sqlFactory.openSession();
            daoKV.put("lookup", (IDbDao)sqlSession.getMapper(Class.forName("com.pd.it.lookup.ILookupDao")));
            daoKV.put("menu", (IDbDao)sqlSession.getMapper(Class.forName("com.pd.it.menu.IMenuDao")));
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
    
    public static IDbDao get(String key)
    {
        if (daoKV == null)
        {
            synchronized (daoKV)
            {
                if (daoKV == null)
                {
                    initDaoKv();
                }
            }
        }
        return daoKV.get(key);
    }
}
