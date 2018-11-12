package com.pd.it.module.todo;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.ISimpleDao;
import com.pd.it.common.vo.VO;

@Repository
public interface ITodoDao extends ISimpleDao<VO> {

}