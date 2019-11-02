package com.pd.it.web.api;

import org.springframework.web.bind.annotation.RequestMapping;

import com.pd.base.model.ResultVO;
import com.pd.it.common.Reflects;

public interface ISimpleRest extends IRest {
	@RequestMapping(value = "/get")
	default Object get(Object in) {
		ISimpleDao dao = Reflects.field(this, "dao", ISimpleDao.class);
		if (dao != null) {
			return dao.get(in);
		}
		ISimpleService service = Reflects.field(this, "service", ISimpleService.class);
		if (service != null) {
			return service.get(in);
		}
		return ResultVO.NOT_SUPPORT;
	}
}
