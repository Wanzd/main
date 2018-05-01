package com.pd.it.common.util;

import java.util.List;

import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.vo.VO;

public class LookupUtil
{
    public static List<VO> raType(VO vo)
    {
        IDbDao lookupTypeDao = BeanUtil.<IDbDao> getBean("com.pd.it.dao.System$ILookupTypeDao");
        return lookupTypeDao.ra(vo);
    }
    
    public static List<VO> raItem(VO vo)
    {
        IDbDao lookupDao = BeanUtil.<IDbDao> getBean("com.pd.it.dao.System$ILookupDao");
        return lookupDao.ra(vo);
    }
}
