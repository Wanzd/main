package com.pd.ai.web;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pd.base.model.Attr;
import com.pd.base.model.VO;
import com.pd.it.web.api.ISimpleRest;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/mathRest")
public class AppMathRestService implements ISimpleRest {

	@RequestMapping(value = "ra")
	public String rest() {
		VO vo = new VO(new Attr("a", "1"), new Attr("now", new Date()));
		return JSON.toJSONString(vo);
	}

}
