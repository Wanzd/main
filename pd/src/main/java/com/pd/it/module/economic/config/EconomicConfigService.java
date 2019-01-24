package com.pd.it.module.economic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.ISimpleDbService;
import com.pd.it.common.vo.VO;

@Service("economicConfigService")
public class EconomicConfigService implements ISimpleDbService<VO, IEconomicConfigDao> {

	@Autowired
	private IEconomicConfigDao dao;

	@Override
	public IEconomicConfigDao getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

}