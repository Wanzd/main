package com.pd.it.rest.impl;

import org.springframework.context.ApplicationContext;

import com.pd.base.model.MapVO;
import com.pd.it.common.ObjectX;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.operation.api.IQueryOperation;

public class IQueryOperationBuilder implements IBuilder<Object, Object> {

	@Override
	public Object build(Object in) {
		ApplicationContext ctx = SpringUtil.getContext();
		MapVO mapVO = ObjectX.x(in, MapVO.class);
		String beanName = mapVO.str("beanName");
		IQueryOperation bean = ctx.getBean(beanName, IQueryOperation.class);
		return bean.query(in);
	}

}
