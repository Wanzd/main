package com.pd.it.system.redis;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.common.util.x.Trans;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.RedisDao;
import com.pd.it.web.itf.service.ICommonService;

@Service
public class RedisHashService implements ICommonService {

	@Inject
	protected RedisDao dao;

	@Override
	public Object executeR(VO fo) {
		RedisFO redisFO = Trans.obj(fo, RedisFO.class);
		return dao.hget(redisFO.getHkey(), redisFO.getKey());
	}

	@Override
	public Object executeRa(VO fo) {
		RedisFO redisFO = Trans.obj(fo, RedisFO.class);
		return dao.hgetAll(redisFO.getHkey());
	}

	@Override
	public Object executeUpdate(VO fo) {
		RedisFO redisFO = Trans.obj(fo, RedisFO.class);
		return dao.hset(redisFO.getHkey(), redisFO.getKey(), redisFO.getValue());
	}
}
