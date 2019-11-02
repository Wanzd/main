package com.pd.it.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pd.it.common.Reflects;
import com.pd.it.common.StringListX;

public interface IRest {
	@RequestMapping(value = "/serviceList")
	default List<Object> serviceList() {
		List rsList = new ArrayList<>();
		rsList = StringListX.listAttr(Reflects.methods(this), "name");
		return rsList;
	}

	@RequestMapping(value = "/help/{service}")
	default List<Object> help(@PathVariable("service") String service) {
		List rsList = new ArrayList<>();
		rsList = StringListX.listAttr(Reflects.methods(this, service), "name");
		return rsList;
	}
}
