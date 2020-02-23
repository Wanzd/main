package com.pd.it.app.sari.builder;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.pd.base.model.MapVO;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.operation.api.IQueryListOperation;

public class DataSourceViewBuilder implements IBuilder<MapVO, List<MapVO>> {

	@Override
	public List<MapVO> build(MapVO in) {
		ApplicationContext ctx = SpringUtil.getContext();
		String viewName = in.str("detail");
		IQueryListOperation bean = ctx.getBean("IViewDao", IQueryListOperation.class);
		MapVO fo = new MapVO();
		fo.put("viewName", viewName);
		return bean.queryList(fo);
	}

}
