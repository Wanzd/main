package com.pd.common.util;

import com.pd.common.exception.CommonException;
import com.pd.ehr.base.atom.EhrDate;

public class LogService
{
    private String name;
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private Class<?> cla = null;
    
    public LogService(String name, Class<?> cla)
    {
        this.name = name;
        this.cla = cla;
    }
    
    private void log(String type, Object msg)
    {
        String msg2 = String.format("[ %s %s ]%s", type, EhrDate.getNow(), msg);
        System.out.println(msg2);
    }
    
    public void detail(Object msg)
    {
        if (LogUtil.isDetailMode())
        {
            log("detail", msg);
        }
    }
    
    public void debug(Object msg)
    {
        if (LogUtil.isDebugMode())
        {
            log("debug", msg);
        }
    }
    
    public void commonException(String errorMsg)
        throws CommonException
    {
        throw new CommonException(cla.getName() + ":" + errorMsg);
    }
    
}
