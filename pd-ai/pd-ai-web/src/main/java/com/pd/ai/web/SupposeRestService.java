package com.pd.ai.web;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.ai.dao.IEntitySupposeDao;
import com.pd.it.web.api.ISimpleRest;

/**
 * 实体联想rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/supposeRest")
public class SupposeRestService implements ISimpleRest {

	@Inject
	protected IEntitySupposeDao dao;
}
