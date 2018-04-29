package com.pd.web.util;

import com.pd.it.common.vo.VO;
import com.pd.web.itf.IAction;

public class ActionUtil
{
    
    public static String action(VO path, VO vo)
    {
        
        IAction action = DbActionUtil.get(path);
        if (action == null)
        {
            return null;
        }
        String rsStr = action.action(path, vo);
        return rsStr;
        
    }
    
}
