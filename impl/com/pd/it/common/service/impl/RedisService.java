// package com.pd.it.common.service.impl;
//
// import java.util.List;
//
// import com.pd.it.common.itf.IService;
// import com.pd.it.common.redis.vo.RedisFO;
// import com.pd.it.common.redis.vo.RedisVO;
// import com.pd.it.common.util.AI;
//
// import redis.clients.jedis.Jedis;
// import redis.clients.jedis.Transaction;
//
// public class RedisService<RedisVO, RedisFO> implements IService<RedisVO, RedisFO>
// {
//
// @Override
// public int c(RedisVO vo)
// {
// Jedis jedis = new Jedis("127.0.0.1");
// jedis.connect();
// Transaction tx = jedis.multi();
//
// for (int i = 0; i < 100000; i++)
// {
//
// tx.set("t" + i, "t" + i);
//
// }
//
// List<Object> results = tx.exec();
// jedis.disconnect();
// return 0;
// }
//
// @Override
// public RedisVO r(RedisFO fo)
// {
// Jedis jedis = new Jedis("127.0.0.1");
// jedis.connect();
// String v = jedis.get("t1");
// jedis.disconnect();
// return AI.c(RedisVO.class, "k", fo.getK(), "v", v);
// }
//
// @Override
// public int d(RedisVO vo)
// {
// return 0;
// }
//
// @Override
// public int u(RedisVO vo)
// {
// return 0;
// }
//
// }
