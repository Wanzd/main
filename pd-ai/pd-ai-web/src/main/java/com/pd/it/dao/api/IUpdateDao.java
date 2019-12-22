package com.pd.it.dao.api;

import java.sql.SQLException;
import java.util.List;

public interface IUpdateDao<DTO> {
	int insertList(List<DTO> list) throws SQLException;

	int updateList(List<DTO> list) throws SQLException;

	int deleteList(List<DTO> list) throws SQLException;
}
