package com.pd.it.module.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDimensionRestService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/todoRest")
public class TodoRestService implements IDimensionRestService {
	@Autowired
	protected TodoService todoService;
	@Autowired
	protected TodoSuggestService suggestService;

}
