package com.pd.it.rest.api;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pd.it.common.Method2Map;
import com.pd.it.common.Reflects;

public interface IHelpRest {

	@RequestMapping(value = "/help/{service}")
	default List<Object> help(@PathVariable("service") String service) {
		List rsList = new ArrayList<>();
		List<Method> methodList = Reflects.methods(this, service);
		rsList = methodList.stream().map(Method2Map::transform).collect(Collectors.toList());
		return rsList;
	}
}
