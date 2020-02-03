package com.pd.ai.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.StringX;
import com.pd.it.rest.api.IDimensionQueryRest;
import com.pd.it.rest.api.IRest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 系统菜单rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/rest/system/redis")
public class SystemRedisRest implements IRest, IDimensionQueryRest<Object, Object> {
	@Inject
	private JedisPool jedisPool;

	@RequestMapping(value = "/query{dimension}/{key}")
	@ResponseBody
	public Object queryDimension(@PathVariable String key, @PathVariable String dimension) {
		dimension = StringX.decap(dimension);
		Jedis jedis = jedisPool.getResource();
		if (dimension.length() == 0) {
			return jedis.get(key);
		}
		return jedis.hget(dimension, key);
	}

	@RequestMapping(value = "/update{dimension}/{key}/{value}")
	@ResponseBody
	public Object updateDimension(@PathVariable String key, @PathVariable String value,
			@PathVariable String dimension) {
		dimension = StringX.decap(dimension);
		Jedis jedis = jedisPool.getResource();
		if (dimension.length() == 0) {
			return jedis.set(key, value);
		}
		return jedis.hset(dimension, key, value);
	}
}
