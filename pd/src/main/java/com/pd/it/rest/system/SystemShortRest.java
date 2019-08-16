package com.pd.it.rest.system;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("")
public class SystemShortRest {

	@Inject
	protected LookupItemBusiness lookupItemBusiness;

	/**
	 * 按id查询相关的lookupList
	 * 
	 * @param in
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/LOOKUP:{typeId}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object queryList(@PathVariable String typeId) {
		LookupItemFO fo = new LookupItemFO();
		fo.setTypeId(typeId);
		Object ra = lookupItemBusiness.queryList(fo);
		return StringX.json(ra);
	}
}
