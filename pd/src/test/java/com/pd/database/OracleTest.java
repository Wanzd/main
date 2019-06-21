package com.pd.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class OracleTest {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521/dev";
	private String user="sys as sysdba";
	private String password="ww";

	@Test
	public void testSelect() {
		try {
			Class.forName(driver);
			//DriverManager.setLoginTimeout(2);
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement prepareStatement = conn.prepareStatement("select * from t1");
			ResultSet executeQuery = prepareStatement.executeQuery();
			executeQuery.next();
			System.out.println(executeQuery.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
