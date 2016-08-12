package com.pd.common.util;

public class ShowUtil
{
    public static void show(Object obj)
    {
        if (obj instanceof Object)
        {
            LogUtil.detail(obj);
        }
        else
        {
            LogUtil.detail("Null!");
        }
    }
}
