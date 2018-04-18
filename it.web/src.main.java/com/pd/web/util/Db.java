package com.pd.web.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.util.AI;
import com.pd.it.common.vo.VO;

public class Db
{
    
    public static String action(VO in, VO path)
    {
        IDbDao dao = getDao(in);
        if (dao == null)
        {
            return null;
        }
        String action = in.get("action").toString();
        String rsStr = null;
        switch (action)
        {
            case "c":
                int c = dao.c(in);
                rsStr = c + "";
            case "r":
                VO r = dao.r(in);
                rsStr = JSON.toJSONString(r);
            case "ra":
                List<VO> ra = dao.ra(in);
                rsStr = JSON.toJSONString(ra);
            case "rs":
                List<VO> rs = dao.rs(in);
                rsStr = JSON.toJSONString(rs);
            case "p":
                List<VO> p = dao.p(in);
                rsStr = JSON.toJSONString(p);
            case "batch":
                List<VO> createList = (List<VO>)in.get("createList");
                if (createList != null)
                {
                    dao.cs(createList);
                }
                List<VO> deleteList = (List<VO>)in.get("deleteList");
                if (deleteList != null)
                {
                    dao.ds(deleteList);
                }
                List<VO> updateList = (List<VO>)in.get("updateList");
                if (updateList != null)
                {
                    dao.cs(updateList);
                }
                rsStr = "0";
        }
        return rsStr;
    }
    
    private static IDbDao getDao(VO vo)
    {
        String mid = vo.get("mid").toString();
        IDbDao iDbDao = DaoUtil.get(mid);
        return AI.nvl(iDbDao, null);
    }
}
