package com.pd.it.system.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("")
public class ShortLookupRestService {
	@Autowired
	protected LookupTypeService lookupType;
	@Autowired
	protected LookupItemService lookupItem;

	@ResponseBody
	@RequestMapping(value = "/LOOKUP_TYPE", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object listLookupType() {
		Object ra = lookupType.query(new FO());
		return X.jsonStr(ra);
	}

	@ResponseBody
	@RequestMapping(value = "/LOOKUP:{typeId}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object listLookupItemByType(@PathVariable("typeId") String typeId) {
		FO fo = new FO();
		fo.put("typeId", typeId);
		Object ra = lookupType.query(fo);
		return X.jsonStr(ra);
	}
}
