package com.pd.it.system.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.ICommonDbService;
import com.pd.it.web.itf.service.ICommonService;

@Service
public class LookupItemService implements ICommonService {

	@Autowired
	private ILookupItemDao dao;

}
