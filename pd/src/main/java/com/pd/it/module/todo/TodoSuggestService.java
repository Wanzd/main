package com.pd.it.module.todo;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.web.itf.service.IQueryService;

@Service
public class TodoSuggestService implements IQueryService {

	@Inject
	protected ITodoDao dao;

}
