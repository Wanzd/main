package com.pd.it.system.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.ISimpleDao;
import com.pd.it.common.itf.ISimpleDbService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service("systemUserService")
public class SystemUserService implements ISimpleDbService<VO, ISimpleDao<VO>> {

	@Autowired
	private MongoTemplate mongo;

	@Override
	public ISimpleDao<VO> getDao() {
		return null;
	}

	@Override
	public Object r(FO vo) {
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
