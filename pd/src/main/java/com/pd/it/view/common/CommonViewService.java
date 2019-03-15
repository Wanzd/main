package com.pd.it.view.common;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.web.itf.IQueryService;

@Service
public class CommonViewService implements IQueryService {
	@Inject
	private ICommonViewDao dao; 

}
