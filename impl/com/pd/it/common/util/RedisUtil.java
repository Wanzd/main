package com.pd.it.common.util;

import com.pd.it.common.service.impl.RedisService;

public class RedisUtil
{
    public static RedisService c() {
        return new RedisService();
    }
}
