package com.pd.ai.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.ai.dao.impl.IEntitySupposeDao;
import com.pd.it.rest.api.IRest;

/**
 * 实体联想rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/supposeRest")
public class SupposeRestService implements IRest {
	@Inject
	protected IEntitySupposeDao dao;
}
