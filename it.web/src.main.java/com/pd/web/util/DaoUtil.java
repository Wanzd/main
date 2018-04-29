package com.pd.web.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.VO;

public class DaoUtil
{
    private static Map<String, IDbDao> daoKV = null;
    
    private static SqlSession sqlSession;
    
    /**
     * 初始化dao反射
     */
    private static void initDaoKv()
    {
        try
        {
            daoKV.clear();
            WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
            SqlSessionFactory sqlFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
            sqlSession = sqlFactory.openSession();
            IDbDao daoKvDao = (IDbDao)sqlSession.getMapper(Class.forName("com.pd.it.system.daoKv.IDaoKvDao"));
            List<VO> ra = daoKvDao.ra(null);
            for (VO eachVO : ra)
            {
                Object mapper = sqlSession.getMapper(Class.forName(eachVO.get("value").toString()));
                if (mapper instanceof IDbDao)
                {
                    daoKV.put(eachVO.get("id").toString(),
                        (IDbDao)sqlSession.getMapper(Class.forName(eachVO.get("value").toString())));
                }
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
    
    public static IDbDao get(VO vo)
    {
        if (daoKV == null)
        {
            daoKV = new HashMap<String, IDbDao>();
            synchronized (daoKV)
            {
                if (daoKV.size() == 0)
                {
                    initDaoKv();
                }
            }
        }
        return daoKV.get(X.v(vo, "module"));
    }
    
}
