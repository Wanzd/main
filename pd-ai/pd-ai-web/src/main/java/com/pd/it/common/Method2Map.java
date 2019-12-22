package com.pd.it.common;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import com.pd.base.model.MapVO;

public class Method2Map {
	public static MapVO transform(Method in) {
		MapVO rsMap = new MapVO();
		rsMap.put("name", in.getName());
		List<String> list = ListX.array(in.getParameters()).stream()
				.map(param -> param.getType().getName() + " " + param.getName()).collect(Collectors.toList());
		rsMap.put("param", list);
		rsMap.put("return", in.getReturnType().getTypeName());
		return rsMap;
	}

}
