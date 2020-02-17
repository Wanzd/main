package com.pd.it.operation.api;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pd.base.model.PageVO;

public interface IQueryPagedListOperation<FO, DTO> {
	List<DTO> queryPagedList(@Param("fo") FO in, @Param("page") PageVO page);

	int queryCount(@Param("fo") FO fo);
}
