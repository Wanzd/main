package com.pd.common.util;

import com.pd.common.exception.CommonException;

public class ExceptionUtil
{
    public static void exception(String errorMsg)
        throws CommonException
    {
        throw new CommonException(errorMsg);
    }
}
