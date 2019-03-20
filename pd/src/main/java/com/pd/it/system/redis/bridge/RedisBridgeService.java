package com.pd.it.system.redis.bridge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.RedisDao;

@RestController
@RequestMapping("redisBridge")
public class RedisBridgeService {

	@Autowired
	private RedisDao dao;

	@ResponseBody
	@RequestMapping(value = "r/{key}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String r(@PathVariable("key") String key) {
		return dao.get(key);
	}

	@ResponseBody
	@RequestMapping(value = "u/{key}/{value}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String u(@PathVariable("key") String key, @PathVariable("value") String value) {
		return dao.set(key, value);
	}

	@ResponseBody
	@RequestMapping(value = "hr/{hkey}/{key}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String hr(@PathVariable("hkey") String hkey, @PathVariable("key") String key) {
		return dao.hget(hkey, key);
	}

	@ResponseBody
	@RequestMapping(value = "hu/{hkey}/{key}/{value}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String hu(@PathVariable("hkey") String hkey, @PathVariable("key") String key,
			@PathVariable("value") String value) {
		return dao.hset(hkey, key, value) + "";
	}

	@ResponseBody
	@RequestMapping(value = "ha/{hkey}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String hReadAll(@PathVariable("hkey") String hkey) {
		return JSON.toJSONString(dao.hgetAll(hkey));
	}
}
