package com.pd.it.sys.datasource.builder;

import com.pd.base.model.MapVO;
import com.pd.it.common.SpringUtil;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.system.obj.dao.ISystemObjDao;

public class DataSourceObjBuilder implements IBuilder<MapVO, Object> {

	@Override
	public Object build(MapVO in) {
		String objId = in.str("detail");
		ISystemObjDao dao = SpringUtil.getBean("ISystemObjDao", ISystemObjDao.class);
		MapVO fo = new MapVO();
		fo.put("objId", objId);
		String jsonData = dao.query(fo);
		return new MapVO(jsonData);
	}

}
