package com.pd.it.app.project;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.ISimpleDao;
import com.pd.it.common.vo.VO;

@Repository
public interface IProjectReportDao extends ISimpleDao<VO<ProjectReportVO>> {

}