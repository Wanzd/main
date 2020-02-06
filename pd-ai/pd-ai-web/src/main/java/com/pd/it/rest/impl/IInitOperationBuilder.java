package com.pd.it.rest.impl;

import org.springframework.context.ApplicationContext;

import com.pd.base.model.MapVO;
import com.pd.it.common.ObjectX;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.StringX;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.operation.api.IInitOperation;

public class IInitOperationBuilder implements IBuilder<Object, Object> {

	@Override
	public Object build(Object in) {
		ApplicationContext ctx = SpringUtil.getContext();
		MapVO mapVO = ObjectX.x(in, MapVO.class);
		String beanName = StringX.cap(mapVO.str("domain")) + StringX.cap(mapVO.str("module"))
				+ StringX.cap(mapVO.str("dimension"));
		IInitOperation bean = ctx.getBean("I"+beanName + "Dao", IInitOperation.class);
		bean.initTable();
		bean.initData();
		return 0;
	}

}
