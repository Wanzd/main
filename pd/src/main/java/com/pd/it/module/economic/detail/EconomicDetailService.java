package com.pd.it.module.economic.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IDbDimensionService;

@Service
public class EconomicDetailService implements IDbDimensionService<IEconomicDetailDao> {

	@Autowired
	private IEconomicDetailDao dao;

	@Override
	public IEconomicDetailDao getDao() {
		return dao;
	}

}
