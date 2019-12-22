package com.pd.ai.web;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.pd.base.model.Attr;
import com.pd.base.model.ValueObject;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("systemMenu")
public class SystemMenuRestService {

	private static SerializeConfig mapping = new SerializeConfig();
	{
		mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
	}

	@RequestMapping(value = "ra")
	public String rest() {
		ValueObject vo = new ValueObject(new Attr("a", "1"), new Attr("now", new Date()));

		return JSON.toJSONString(vo, mapping);
	}

	@RequestMapping(value = "date")
	@ResponseBody
	public Date date() {
		return new Date();
	}

}
