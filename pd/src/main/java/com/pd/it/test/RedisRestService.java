package com.pd.it.test;

import javax.inject.Inject;
import javax.ws.rs.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.dao.RedisDao;
import com.pd.it.system.redis.RedisFO;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/redis")
public class RedisRestService {

	@Inject
	private RedisDao redis;

	@ResponseBody
	@RequestMapping(value = "/get/{key}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object get(@PathVariable("key") String key) {
		return redis.get(key);
	}

	@ResponseBody
	@RequestMapping(value = "/set/{key}/{value}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object set(@PathParam("") RedisFO fo) {
		return redis.set(fo.getKey(), fo.getValue());
	}

	@ResponseBody
	@RequestMapping(value = "/hget/{hkey}/{key}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object hget(@PathParam("") RedisFO fo) {
		return redis.hget(fo.getHkey(), fo.getKey());
	}

	@ResponseBody
	@RequestMapping(value = "/hget/{hkey}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object hgetAll(@PathParam("") RedisFO fo) {
		return redis.hgetAll(fo.getHkey());
	}

	@ResponseBody
	@RequestMapping(value = "/hset/{hkey}/{key}/{value}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object hset(@PathParam("") RedisFO fo) {
		return redis.hset(fo.getHkey(), fo.getKey(), fo.getValue());
	}

}
