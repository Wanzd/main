package com.pd.it.rest.system.menu;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.business.system.menu.MenuBusiness;
import com.pd.it.common.exception.AppException;
import com.pd.it.common.util.StringX;
import com.pd.it.model.system.menu.MenuFO;

/**
 * 报表rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/system/menuRest")
public class MenuRest {

	@Inject
	protected MenuBusiness business;

	@ResponseBody
	@RequestMapping(value = "/queryList", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object queryList(@RequestBody(required = false) MenuFO in) throws AppException {
		Object ra = business.queryList(in);
		return StringX.json(ra);
	}
}
