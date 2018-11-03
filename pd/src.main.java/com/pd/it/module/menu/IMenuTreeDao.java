package com.pd.it.module.menu;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.IDao;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Repository
public interface IMenuTreeDao extends IDao<VO, FO, VO> {

}