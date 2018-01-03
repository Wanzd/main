package com.pd.it.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pd.it.common.redis.vo.RedisFO;
import com.pd.it.common.redis.vo.RedisVO;
import com.pd.it.common.service.impl.RedisService;
import com.pd.it.common.util.AI;

public class RedisTest
{
    @Test
    public void testR()
    {
        RedisService redis = new RedisService();
        
        RedisVO vo = AI.<RedisVO> c(RedisVO.class, "k", "a", "v", "b");
        redis.c(vo);
        RedisFO fo = AI.<RedisFO> c(RedisFO.class, "k", "a");
        RedisVO r = redis.r(fo);
        assertEquals("b", r.getV());
    }
}
