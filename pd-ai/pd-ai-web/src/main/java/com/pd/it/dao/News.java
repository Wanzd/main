package com.pd.it.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryDao;

public class News {
	@Repository("News$IDao")
	public static interface IDao extends IQueryDao<MapVO, MapVO> {
	}
}