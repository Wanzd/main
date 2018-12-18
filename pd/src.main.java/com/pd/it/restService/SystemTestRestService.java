package com.pd.it.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.X;
import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;
import com.pd.it.system.user.SystemUserService;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("test/system")
public class SystemTestRestService {

	@Autowired
	private SystemUserService systemUserService;

	@ResponseBody
	@RequestMapping(value = "/user/r/{id}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String rest(@PathVariable("id") String id) {
		VO vo = new VO(new Attr("id", id));
		Object rs= systemUserService.r(vo);
		if(rs==null) {
			return X.jsonStr(ResultVO.error("NotFound"));
		}
		return X.jsonStr(rs);
	}

}
