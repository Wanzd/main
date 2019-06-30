package com.pd.it.app.person.dao;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.ISimpleDao;
import com.pd.it.common.vo.VO;

@Repository
public interface IPersonDao extends ISimpleDao<VO> {

}