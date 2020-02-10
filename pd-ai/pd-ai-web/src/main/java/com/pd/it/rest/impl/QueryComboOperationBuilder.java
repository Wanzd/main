package com.pd.it.rest.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.pd.base.model.MapVO;
import com.pd.it.common.ObjectX;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.dao.api.IQueryComboDao;

public class QueryComboOperationBuilder implements IBuilder<Object, Object> {

	@Override
	public Object build(Object in) {
		ApplicationContext ctx = SpringUtil.getContext();
		MapVO mapVO = ObjectX.x(in, MapVO.class);
		String beanName = mapVO.str("beanName");
		IQueryComboDao bean = ctx.getBean(beanName, IQueryComboDao.class);
		List rs = bean.queryCombo(mapVO);
		return rs;
	}

}
