package com.pd.it.dao.api;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IUpdateDao<DTO> {
	int insertList(@Param("list") List<DTO> list) throws SQLException;

	int updateList(@Param("list")List<DTO> list) throws SQLException;

	int deleteList(@Param("list")List<DTO> list) throws SQLException;

	int delete(DTO dto) throws SQLException;
}
