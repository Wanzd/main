package com.pd.it.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.ComboVO;
import com.pd.base.model.MapVO;
import com.pd.it.common.ObjectX;
import com.pd.it.common.Reflects;
import com.pd.it.common.constants.RestPathConst;
import com.pd.it.operation.api.IQueryComboOperation;

public interface IQueryComboRest<FO, DTO> {

	@RequestMapping(value = RestPathConst.QUERY_COMBO)
	@ResponseBody
	default List<ComboVO> queryCombo(@RequestBody(required = false) JSONObject fo) {
		IQueryComboOperation op = Reflects.firstExistField(this, IQueryComboOperation.class, "dao,service,business");
		return op.queryCombo(ObjectX.x(fo, MapVO.class));
	}

}
