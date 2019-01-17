package com.pd.it.module.economic.monthly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.ISimpleDbService;
import com.pd.it.common.vo.VO;

@Service("economicMonthlyService")
public class EconomicMonthlyService implements ISimpleDbService<VO, IEconomicMonthlyDao> {

	@Autowired
	private IEconomicMonthlyDao dao;

	@Override
	public IEconomicMonthlyDao getDao() {
		return dao;
	}

}
