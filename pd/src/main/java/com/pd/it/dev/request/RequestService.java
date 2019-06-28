package com.pd.it.dev.request;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.IQueryService;
import com.pd.it.web.itf.service.ISaveService;

@Service
public class RequestService implements IQueryService, ISaveService {

	@Inject
	protected IRequestDao dao;

}
