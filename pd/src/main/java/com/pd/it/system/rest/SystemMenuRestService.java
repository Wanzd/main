package com.pd.it.system.rest;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.VO;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("system/menu")
public class SystemMenuRestService {

	private static SerializeConfig mapping = new SerializeConfig();
	{
		mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
	}

	@RequestMapping(value = "ra")
	public String rest() {
		VO vo = new VO(new Attr("a", "1"), new Attr("now", new Date()));

		return JSON.toJSONString(vo, mapping);
	}

	@RequestMapping(value = "date")
	@ResponseBody
	public Date date() {
		return new Date();
	}

}
