package com.pd.it.module.economic.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IQueryService;

@Service
public class EconomicDetailService implements IQueryService {

	@Autowired
	protected IEconomicDetailDao dao;

}
