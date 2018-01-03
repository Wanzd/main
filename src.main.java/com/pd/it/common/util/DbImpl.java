//package com.pd.it.common.util;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DbImpl implements IService {
//	private Connection con = new DbBuilder().build(null);
//
//
//	public JSONObject r(JSONObject _vo) {
//		$logF();
//		String sqlStr = _vo.getString("sql");
//		$debug("_sql:", _vo);
//		Statement stmt;
//		try {
//			stmt = con.createStatement();
//			JSONObject rsJO = new JSONObject();
//			JSONArray ja = new JSONArray();
//			int totalCount = 0;
//			ResultSet rs = stmt.executeQuery(sqlStr);
//			while (rs.next()) {
//				totalCount++;
//				ja.add(_rs2json(rs));
//			}
//			rsJO.put("totalCount", totalCount);
//			rsJO.put("vos", ja);
//			return rsJO;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public int u(JSONObject _vo) {
//		$logF();
//		String sqlStr = _vo.getString("sql");
//		$debug("_sql:", sqlStr);
//		Statement stmt;
//		try {
//			stmt = con.createStatement();
//			int rs = stmt.executeUpdate(sqlStr);
//			return rs;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
//	public boolean immediate(JSONObject _vo) {
//		$logF();
//		String sqlStr = $v(_vo, "sql");
//		$debug("_sql:", sqlStr);
//		Statement stmt;
//		try {
//			con.setAutoCommit(true);
//			stmt = con.createStatement();
//			boolean rsFlag = stmt.execute(sqlStr);
//			$debug("rsFlag", rsFlag);
//			return rsFlag;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	private static JSONObject _rs2json(ResultSet _rs) {
//		JSONObject jsonObj = new JSONObject();
//		try {
//			ResultSetMetaData metaData = _rs.getMetaData();
//			for (int i = 1, total = metaData.getColumnCount(); i <= total; i++) {
//				String typeName = metaData.getColumnTypeName(i);
//				String colName = metaData.getColumnName(i);
//				String colValue = "";
//				switch (typeName) {
//				case "VARCHAR2":
//					colValue = _rs.getString(i);
//				}
//				jsonObj.put(colName, colValue);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return jsonObj;
//	}
//}
