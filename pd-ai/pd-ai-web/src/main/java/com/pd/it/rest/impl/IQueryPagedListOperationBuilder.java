package com.pd.it.rest.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.pd.base.model.MapVO;
import com.pd.base.model.PageVO;
import com.pd.base.model.PagedResult;
import com.pd.it.common.ObjectX;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.StringX;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.dao.api.IQueryDao;

public class IQueryPagedListOperationBuilder implements IBuilder<Object, Object> {

	@Override
	public Object build(Object in) {
		ApplicationContext ctx = SpringUtil.getContext();
		MapVO mapVO = ObjectX.x(in, MapVO.class);
		String beanName = StringX.cap(mapVO.str("domain")) + StringX.cap(mapVO.str("module"))
				+ StringX.cap(mapVO.str("dimension"));
		IQueryDao bean = ctx.getBean("I" + beanName + "Dao", IQueryDao.class);
		Object fo = ObjectX.get(in, "fo", Object.class);
		PageVO pageVO = ObjectX.get(in, "pageVO", PageVO.class);
		List pagedList = bean.queryPagedList(fo, pageVO);
		int count = bean.queryCount(fo);
		pageVO.setTotal(count);
		return new PagedResult(pagedList, pageVO);
	}

}
