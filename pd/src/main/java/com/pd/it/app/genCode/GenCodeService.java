package com.pd.it.app.genCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.ICommonService;

@Service
public class GenCodeService implements ICommonService {

	@Autowired
	protected IGenCodeDao dao;

}
