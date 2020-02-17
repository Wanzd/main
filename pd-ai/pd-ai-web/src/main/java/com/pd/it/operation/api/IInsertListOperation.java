package com.pd.it.operation.api;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IInsertListOperation<VO> {

	int insertList(@Param("list") List<VO> list);

}
