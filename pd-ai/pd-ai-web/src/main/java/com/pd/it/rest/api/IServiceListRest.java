package com.pd.it.rest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;

import com.pd.it.common.Reflects;
import com.pd.it.common.StringListX;

public interface IServiceListRest {
	@RequestMapping(value = "/serviceList")
	default List<String> serviceList() {
		List<String> rsList = new ArrayList<>();
		rsList = StringListX.listAttr(Reflects.methods(this), "name");
		rsList = rsList.stream().distinct()
				.filter(str -> !str.matches("equals|getClass|hashCode|notify|notifyAll|toString|wait")).sorted()
				.collect(Collectors.toList());
		return rsList;
	}
}
