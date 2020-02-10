package com.pd.it.rest.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.pd.base.model.MapVO;
import com.pd.it.common.ObjectX;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.StringX;
import com.pd.it.common.impl.TreeListBuilder;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.dao.api.IQueryDao;

public class IQueryTreeListOperationBuilder implements IBuilder<Object, Object> {

	@Override
	public Object build(Object in) {
		ApplicationContext ctx = SpringUtil.getContext();
		MapVO mapVO = ObjectX.x(in, MapVO.class);
		String beanName = mapVO.str("beanName");
		IQueryDao bean = ctx.getBean(beanName, IQueryDao.class);
		List rs = bean.queryList(in);
		mapVO.put("list",rs);
		rs=new TreeListBuilder().build(mapVO);
		return rs;
	}

}
