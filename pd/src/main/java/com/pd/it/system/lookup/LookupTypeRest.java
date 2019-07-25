package com.pd.it.system.lookup;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.business.system.lookup.type.LookupTypeBusiness;
import com.pd.it.common.util.StringX;
import com.pd.it.common.vo.FO;

/**
 * 报表rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/system/lookupTypeRest")
public class LookupTypeRest {

	@Inject
	protected LookupTypeBusiness business;

	@ResponseBody
	@RequestMapping(value = "/queryList", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object queryLookupTypeList(@RequestBody(required = false) FO in) {
		Object ra = business.queryList(in);
		return StringX.json(ra);
	}
}
