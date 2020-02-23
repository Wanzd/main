package com.pd.it.operation.api;

import org.apache.ibatis.annotations.Param;

public interface IQueryOperation<FO, DTO> {
	DTO query(@Param("fo") FO in);
}
