package com.pd.it.operation.api;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pd.base.model.ComboVO;
import com.pd.base.model.MapVO;

public interface IQueryComboOperation {
	List<ComboVO> queryCombo(@Param("fo") MapVO fo);
}
