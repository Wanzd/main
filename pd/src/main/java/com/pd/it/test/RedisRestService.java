package com.pd.it.test;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDimensionRestService;
import com.pd.it.system.redis.RedisHashService;
import com.pd.it.system.redis.RedisKVService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/redis")
public class RedisRestService implements IDimensionRestService {

	@Inject
	protected RedisKVService kv;
	@Inject
	protected RedisHashService h;

}
