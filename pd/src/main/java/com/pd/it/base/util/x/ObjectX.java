package com.pd.it.base.util.x;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.util.StringX;

public class ObjectX {

	public static <OUT> OUT x(Object vo, Class<OUT> outClass) {
		String jsonStr = StringX.json(vo);
		OUT rs = JSON.parseObject(jsonStr, outClass);
		return rs;
	}

}
