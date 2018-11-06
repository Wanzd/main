package com.pd.it.system.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("lookup")
public class LookupRestService {
	@Autowired
	private LookupService service;

	@ResponseBody
	@RequestMapping(value = "list/{typeId}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String list(@PathVariable("typeId") String typeId) {
		FO fo = new FO();
		fo.p("typeId", typeId);
		return X.jsonStr(service.ra(fo));
	}

}
