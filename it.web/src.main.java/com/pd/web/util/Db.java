package com.pd.web.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.vo.VO;

public class Db
{
    public static List<VO> ra(IDbDao dao, VO vo)
    {
        if (dao == null)
        {
            return null;
        }
        return dao.ra(vo);
    }
    public static VO r(IDbDao dao, VO vo)
    {
        if (dao == null)
        {
            return null;
        }
        return dao.r(vo);
    }
    
    public static VO detail(VO path, VO vo)
    {
        IDbDao rsDao = DaoUtil.get(path);
        if (rsDao == null)
        {
            return null;
        }
        return rsDao.detail(vo);
    }
    
    public static List<VO> rs(VO path, VO vo)
    {
        IDbDao rsDao = DaoUtil.get(path);
        if (rsDao == null)
        {
            return null;
        }
        return rsDao.rs(vo);
    }
    
    public static String batch(VO path, VO vo)
    {
        int rsInt = -1;
        IDbDao rsDao = DaoUtil.get(path);
        List<VO> createList = (List<VO>)vo.get("createList");
        if (createList != null)
        {
            rsInt += rsDao.cs(createList);
        }
        List<VO> deleteList = (List<VO>)vo.get("deleteList");
        if (deleteList != null)
        {
            rsInt += rsDao.ds(deleteList);
        }
        List<VO> updateList = (List<VO>)vo.get("updateList");
        if (updateList != null)
        {
            rsInt += rsDao.cs(updateList);
        }
        
        return JSON.toJSONString(rsInt);
    }
}
