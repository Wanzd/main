package com.pd.it.rest.system.lookup;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.business.system.lookup.item.LookupItemBusiness;
import com.pd.it.common.util.StringX;
import com.pd.it.model.system.lookup.item.LookupItemFO;

/**
 * 报表rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/system/lookupItemRest")
public class LookupItemRest {

	@Inject
	protected LookupItemBusiness business;

	@ResponseBody
	@RequestMapping(value = "/queryList", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object queryList(@RequestBody(required = false) LookupItemFO in) {
		Object ra = business.queryList(in);
		return StringX.json(ra);
	}
}
