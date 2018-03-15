package com.pd.web.util;

import org.springframework.web.servlet.ModelAndView;

public class SpringUtil
{
    
    public static ModelAndView jsp(String url, Object... paramKv)
    {
        if (paramKv.length % 2 != 0)
        {
            return null;
        }
        ModelAndView mav = new ModelAndView(url);
        for (int i = 0, total = paramKv.length; i < total; i += 2)
        {
            mav.addObject(paramKv[i].toString(), paramKv[i + 1]);
        }
        return mav;
    }
    
}
