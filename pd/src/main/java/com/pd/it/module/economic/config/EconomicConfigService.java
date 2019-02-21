package com.pd.it.module.economic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.IDbDimensionService;

@Service("economicConfigService")
public class EconomicConfigService implements IDbDimensionService<IEconomicConfigDao> {

	@Autowired
	private IEconomicConfigDao dao;

	@Override
	public IEconomicConfigDao getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	@Override
	public Object validQuery(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object executeQuery(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object validUpdate(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object executeUpdate(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
