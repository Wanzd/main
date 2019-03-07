package com.pd.it.system.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.ICommonService;

@Service
public class LookupTypeService implements ICommonService {

	@Autowired
	private ILookupTypeDao dao;

}
