package com.pd.it.rest.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.StringX;
import com.pd.it.common.vo.FO;
import com.pd.it.service.system.lookup.item.LookupItemService;
import com.pd.it.system.lookup.type.LookupTypeService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("")
public class SystemShortCutRestService {
	@Autowired
	protected LookupTypeService lookupType;
	@Autowired
	protected LookupItemService lookupItem;

	@ResponseBody
	@RequestMapping(value = "/LOOKUP", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object listLookupType() {
		Object ra = lookupType.queryList(new FO());
		return StringX.json(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/LOOKUP/{typeId}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object listLookupItemByType(@PathVariable("typeId") String typeId) {
		FO fo = new FO();
		fo.put("typeId", typeId);
//		Object ra = lookupItem.ra(fo);
		Object ra=null;
		return StringX.json(ra);
	}
}
