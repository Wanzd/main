package com.pd.it.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.it.common.Reflects;
import com.pd.it.common.constants.RestPathConst;
import com.pd.it.operation.api.IQueryListOperation;

public interface IQueryListRest<FO, DTO> {

	@RequestMapping(value = RestPathConst.QUERY_LIST)
	@ResponseBody
	default List<DTO> queryList(@RequestBody JSONObject fo) {
		IQueryListOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryListOperation.class,
				"dao,service,business");
		return operation.queryList((FO) fo);
	}

}
