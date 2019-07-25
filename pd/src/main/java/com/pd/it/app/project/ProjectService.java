package com.pd.it.app.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.PageFO;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;

@Service("projectService")
public class ProjectService {

	@Autowired
	private IProjectDao dao;
	@Autowired
	private IProjectReportDao reportDao;

	public Object list(PageFO fo) {
		return dao.queryPagedList(fo);
	}

	public Object report(FO fo) {
		List<VO> rs = reportDao.queryList(fo);
		if (rs == null || rs.size() == 0) {
			return ResultVO.error("Not Found");
		}
		return rs;
	}

}
