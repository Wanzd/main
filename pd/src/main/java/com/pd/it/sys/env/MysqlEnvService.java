package com.pd.it.sys.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.VO;

@Service("mysqlEnvService")
public class MysqlEnvService {

	@Autowired
	private IMysqlEnvDao mysqlEnvDao;

	public Object init() {
		VO vo = new VO(new Attr("op", "init"));
		return mysqlEnvDao.update(vo);
	}

}
