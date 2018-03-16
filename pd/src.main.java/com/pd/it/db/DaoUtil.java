package com.pd.it.db;

import java.util.HashMap;
import java.util.List;
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
            daoKV.clear();
            WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
            SqlSessionFactory sqlFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
            sqlSession = sqlFactory.openSession();
            IDbDao daoKvDao = (IDbDao)sqlSession.getMapper(Class.forName("com.pd.it.system.daoKv.IDaoKvDao"));
            List<VO> ra = daoKvDao.ra();
            for (VO eachVO : ra)
            {
                daoKV.put(eachVO.get("id").toString(),
                    (IDbDao)sqlSession.getMapper(Class.forName(eachVO.get("value").toString())));
            }
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
            daoKV = new HashMap<String, IDbDao>();
            synchronized (daoKV)
            {
                initDaoKv();
            }
        }
        return daoKV.get(key);
    }
}
