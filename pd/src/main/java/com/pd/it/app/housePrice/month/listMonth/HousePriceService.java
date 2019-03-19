package com.pd.it.app.housePrice.month.listMonth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.util.ListX;
import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;
import com.pd.it.system.user.HousePrice;

@Service("housePriceService")
public class HousePriceService {

	@Autowired
	private MongoTemplate mongo;

	public Object query(FO fo) {
		Query query = new Query();
		List<HousePrice> find = mongo.find(query, HousePrice.class);
		if (find == null) {
			return null;
		}
		return find;
	}

	public Object save(Object object) {
		VO vo = new VO(new Attr("id", "3"), new Attr("name", "c"));
		String jsonStr = JSON.toJSONString(vo);
		HousePrice newVO = JSON.parseObject(jsonStr, HousePrice.class);
		List<HousePrice> list = ListX.from(newVO);
		mongo.insertAll(list);
		return 0;
	}

}
