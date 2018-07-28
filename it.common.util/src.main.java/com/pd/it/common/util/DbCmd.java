package com.pd.it.common.util;

import java.util.List;

import com.pd.it.common.vo.VO;

public class DbCmd
{
    
    public static int u(String sql)
    {
        return Db.u(new VO("sql", sql));
    }
    
    public static VO r(String sql)
    {
        return Db.r(new VO("sql", sql));
    }
    
    public static List<VO> ra(String sql)
    {
        return Db.ra(new VO("sql", sql));
    }
}
