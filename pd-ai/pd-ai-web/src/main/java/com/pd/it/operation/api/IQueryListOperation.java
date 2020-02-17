package com.pd.it.operation.api;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IQueryListOperation<FO, DTO> {

	List<DTO> queryList(@Param("fo") FO in);

}
