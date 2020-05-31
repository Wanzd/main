package com.pd.it.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.PageVO;
import com.pd.base.model.PagedResult;
import com.pd.it.common.Reflects;
import com.pd.it.common.StringX;
import com.pd.it.common.constants.RestPathConst;
import com.pd.it.operation.api.IQueryPagedListOperation;

public interface IQueryDimensionPagedListRest<FO, DTO> {

	@RequestMapping(value = RestPathConst.QUERY_DIMENSION_PAGED_LIST)
	@ResponseBody
	default PagedResult<DTO> queryDimensionPagedList(@RequestBody JSONObject fo, @PathVariable String dimension,
			PageVO pageVO) {
		dimension = StringX.decap(dimension);
		IQueryPagedListOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryPagedListOperation.class,
				dimension + "Dao", dimension + "Service", dimension + "Business");
		List<DTO> pagedList = operation.queryPagedList((FO) fo, pageVO);
		int count = operation.queryCount((FO) fo);
		pageVO.setTotal(count);
		return new PagedResult(pagedList, pageVO);
	}
}
