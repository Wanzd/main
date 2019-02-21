package com.pd.it.module.economic.monthly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IDbDimensionService;

@Service("economicMonthlyService")
public class EconomicMonthlyService implements IDbDimensionService<IEconomicMonthlyDao> {

	@Autowired
	private IEconomicMonthlyDao dao;

	@Override
	public IEconomicMonthlyDao getDao() {
		return dao;
	}

}
