package com.pd.it.system.redis;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.common.util.x.Trans;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.RedisDao;
import com.pd.it.web.itf.service.ICommonService;

@Service
public class RedisKVService implements ICommonService {

	@Inject
	protected RedisDao dao;

	public boolean exists(VO fo) {
		RedisFO redisFO = Trans.obj(fo, RedisFO.class);
		return dao.exists(redisFO.getKey());
	}

	@Override
	public Object executeR(VO fo) {
		RedisFO redisFO = Trans.obj(fo, RedisFO.class);
		return dao.get(redisFO.getKey());
	}

	@Override
	public Object executeRs(VO fo) {
		RedisFO redisFO = Trans.obj(fo, RedisFO.class);
		return dao.rs(redisFO.getKey().split(","));
	}

	@Override
	public Object executeUpdate(VO fo) {
		RedisFO redisFO = Trans.obj(fo, RedisFO.class);
		return dao.set(redisFO.getKey(), redisFO.getValue());
	}

	@Override
	public Object executeDelete(VO fo) {
		RedisFO redisFO = Trans.obj(fo, RedisFO.class);
		return dao.del(redisFO.getKey());
	}
}
