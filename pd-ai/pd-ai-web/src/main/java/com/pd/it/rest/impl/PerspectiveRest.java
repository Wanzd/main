package com.pd.it.rest.impl;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.model.MapVO;
import com.pd.it.rest.api.IQueryRest;
import com.pd.it.system.perspective.dao.ISystemPerspectiveDao;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("perspectiveRest")
public class PerspectiveRest implements IQueryRest<MapVO, MapVO> {
	@Inject
	private ISystemPerspectiveDao dao;
}
