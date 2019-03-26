package com.pd.it.base.util.x;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.util.StringX;

public class ListX {

	public static <OUT> List<OUT> list(Object vo, Class<OUT> outClass) {
		if (vo == null) {
			return null;
		}
		String jsonStr = StringX.json(vo);
		List list = JSON.parseObject(jsonStr, List.class);

		List<OUT> rsList = new ArrayList<>();
		for (Object eachVO : list) {
			rsList.add(ObjectX.x(eachVO, outClass));
		}
		return rsList;
	}

}
