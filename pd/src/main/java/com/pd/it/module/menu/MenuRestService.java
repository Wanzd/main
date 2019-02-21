package com.pd.it.module.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/menuRest")
public class MenuRestService {
	@Autowired
	private MenuTreeService service;

	@ResponseBody
	@RequestMapping(value = "/ra", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object rest(@RequestBody(required = false) FO in) {
		Object ra = service.query(in);
		return X.jsonStr(ra);
	}

}
