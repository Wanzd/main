package com.pd.common.util;

import com.pd.common.exception.CommonException;
import com.pd.common.service.EhrBaseService;

public class LogService extends EhrBaseService
{
    private Class<?> cla = null;
    
    public LogService(String name, Class<?> cla)
    {
        setName(name);
        this.cla = cla;
    }
    
    private void log(String type, Object msg)
    {
        String msg2 = String.format("[ %s %s ]%s", type, DateUtil.getNow(), msg);
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
