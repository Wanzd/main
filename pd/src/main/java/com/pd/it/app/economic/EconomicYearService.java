package com.pd.it.app.economic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.ICommonService;

@Service
public class EconomicYearService implements ICommonService {

	@Autowired
	protected IEconomicYearDao dao;

}
