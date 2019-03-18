package com.pd.it.module.economic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.IQueryService;

@Service("economicConfigService")
public class EconomicConfigService implements IQueryService {

	@Autowired
	protected IEconomicConfigDao dao;

}
