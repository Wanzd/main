package com.pd.web.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.VO;
import com.pd.web.itf.IDbAction;

public class DbActionUtil
{
    private static Map<String, IDbAction> dbActionKV = null;
    
    private static SqlSession sqlSession;
    
    /**
     * 初始化dao反射
     */
    public static void initDaoKv()
    {
        try
        {
            dbActionKV.clear();
            WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
            SqlSessionFactory sqlFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
            sqlSession = sqlFactory.openSession();
            IDbDao daoKvDao = (IDbDao)sqlSession.getMapper(Class.forName("com.pd.it.dao.System$ILookupDao"));
            VO vo = new VO();
            vo.put("type", "dbAction");
            List<VO> ra = daoKvDao.ra(vo);
            for (VO eachVO : ra)
            {
                String value = X.v(eachVO, "value");
                Object instance = Class.forName(value).newInstance();
                if (instance instanceof IDbAction)
                {
                    dbActionKV.put(eachVO.get("id").toString(), (IDbAction)instance);
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
    
    public static IDbAction get(VO path)
    {
        if (dbActionKV == null)
        {
            dbActionKV = new HashMap<String, IDbAction>();
            synchronized (dbActionKV)
            {
                if (dbActionKV.size() == 0)
                {
                    initDaoKv();
                }
            }
        }
        return dbActionKV.get(X.v(path, "action"));
    }
}
