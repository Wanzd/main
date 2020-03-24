package com.pd.it.sys.datasource.builder;

import org.springframework.context.ApplicationContext;

import com.pd.base.model.MapVO;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.impl.TreeListBuilder;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.operation.api.IQueryListOperation;

public class DataSourceTreeGridBuilder implements IBuilder<MapVO, Object> {

	@Override
	public Object build(MapVO in) {
		ApplicationContext ctx = SpringUtil.getContext();
		String viewName = in.str("detail");
		IQueryListOperation bean = ctx.getBean("IViewDao", IQueryListOperation.class);
		MapVO fo = new MapVO();
		fo.put("viewName", viewName);
		in.put("list", bean.queryList(fo));
		return new TreeListBuilder().build(in);
	}

}
