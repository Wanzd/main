package com.pd.it.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDbRestService;
import com.pd.it.common.util.SpringUtil;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.system.lookup.ILookupItemService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/testRest")
public class TestRestService implements IDbRestService {
	@Autowired
	protected ILookupItemService lookupItem;

	@ResponseBody
	@RequestMapping(value = "/test", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public Object test(@RequestBody(required = false) FO in) {
		ILookupItemService service = SpringUtil.getBean("iLookupItemService", ILookupItemService.class);
		Object ra = service.ra(in);
		return ResultVO.json(ra);
	}
}
