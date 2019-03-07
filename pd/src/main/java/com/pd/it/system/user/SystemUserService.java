package com.pd.it.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.IQueryService;

@Service("systemUserService")
public class SystemUserService implements IQueryService {

	@Autowired
	private MongoTemplate mongo;

	@Override
	public Object executeQuery(VO vo) {
		Criteria criteria = new Criteria();
		criteria.andOperator(Criteria.where("code").is(vo.str("id")));
		Query query = new Query();
		query.addCriteria(criteria);
		SystemUser find = mongo.findOne(query, SystemUser.class);
		if (find == null) {
			return null;
		}
		return find;
	}
}
