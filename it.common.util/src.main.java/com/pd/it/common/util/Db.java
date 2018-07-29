package com.pd.it.common.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.provider.CommonSqlProvider;
import com.pd.it.common.vo.VO;

public class Db
{
    private static IDbDao commonDao = null;
    static
    {
        commonDao = BeanUtil.getBean("com.pd.it.dao.ICommonDao");
    }
    
    public static int u(String key)
    {
        return u(key, new VO());
    }
    
    public static int u(String key, List<VO> list)
    {
        return u(key, new VO("list", list));
    }
    
    public static int u(String key, VO in)
    {
        VO cfg = CommonSqlProvider.cfg(key, in);
        return u(cfg);
    }
    
    public static int u(VO vo)
    {
        return commonDao.u(vo);
    }
    
    public static int us(List<VO> list)
    {
        return commonDao.us(list);
    }
    
    public static List<VO> raDao(VO vo)
    {
        return DbCmd.ra("select module ,demension,action,value,json_data as \"jsonData\" from sys_dao_t");
    }
    
    public static List<VO> ra(String key)
    {
        return ra(key, new VO());
    }
    
    public static List<VO> ra(String key, VO vo)
    {
        VO cfg = CommonSqlProvider.cfg(key, vo);
        return ra(cfg);
    }
    
    public static List<VO> ra(VO vo)
    {
        return commonDao.ra(vo);
    }
    
    public static String str(String key, VO vo)
    {
        VO cfg = CommonSqlProvider.cfg(key, vo);
        return commonDao.str(cfg);
    }
    
    public static List<String> strs(String key)
    {
        return strs(key, new VO());
    }
    
    public static List<String> strs(String key, VO vo)
    {
        VO cfg = CommonSqlProvider.cfg(key, vo);
        return commonDao.strs(cfg);
    }
    
    public static VO r(String key, VO vo)
    {
        VO cfg = CommonSqlProvider.cfg(key, vo);
        return r(cfg);
    }
    
    public static VO r(VO vo)
    {
        return commonDao.r(vo);
    }
    
    public static List<VO> rs(VO vo)
    {
        return commonDao.rs(vo);
    }
    
    public static String batch(VO vo)
    {
        int rsInt = -1;
        List<VO> createList = (List<VO>)vo.get("createList");
        if (createList != null)
        {
            rsInt += commonDao.cs(createList);
        }
        List<VO> deleteList = (List<VO>)vo.get("deleteList");
        if (deleteList != null)
        {
            rsInt += commonDao.ds(deleteList);
        }
        List<VO> updateList = (List<VO>)vo.get("updateList");
        if (updateList != null)
        {
            rsInt += commonDao.cs(updateList);
        }
        
        return JSON.toJSONString(rsInt);
    }
    
}
