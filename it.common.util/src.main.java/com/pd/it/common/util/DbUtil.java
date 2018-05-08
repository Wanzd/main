package com.pd.it.common.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.vo.VO;

public class DbUtil
{
    private static IDbDao commonDao = null;
    static
    {
        commonDao = BeanUtil.getBean("com.pd.it.dao.ICommonDao");
    }
    
    public static List<VO> ra(IDbDao dao, VO vo)
    {
        if (dao == null)
        {
            return null;
        }
        return dao.ra(vo);
    }
    
    public static List<VO> raCommon(VO vo)
    {
        return ra(commonDao, vo);
    }
    
    public static VO rCommon(VO vo)
    {
        
        return r(commonDao, vo);
    }
    
    public static VO r(IDbDao dao, VO vo)
    {
        if (dao == null)
        {
            return null;
        }
        return dao.r(vo);
    }
    
    public static List<VO> rs(IDbDao dao, VO vo)
    {
        if (dao == null)
        {
            return null;
        }
        return dao.rs(vo);
    }
    
    public static String batch(IDbDao dao, VO vo)
    {
        int rsInt = -1;
        List<VO> createList = (List<VO>)vo.get("createList");
        if (createList != null)
        {
            rsInt += dao.cs(createList);
        }
        List<VO> deleteList = (List<VO>)vo.get("deleteList");
        if (deleteList != null)
        {
            rsInt += dao.ds(deleteList);
        }
        List<VO> updateList = (List<VO>)vo.get("updateList");
        if (updateList != null)
        {
            rsInt += dao.cs(updateList);
        }
        
        return JSON.toJSONString(rsInt);
    }
    
}
