package com.pd.it.module.economic.monthly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IQueryService;

@Service("economicMonthlyService")
public class EconomicMonthlyService implements IQueryService {

	@Autowired
	protected IEconomicMonthlyDao dao;

}
