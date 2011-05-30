package com.hcs.dao.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBHelper {
	
	private static Configurator dbValue = null;
	
	static {
		try {
			dbValue = new Configurator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get DB Connection
	 * @return
	 */
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		String URL = "jdbc:mysql://" + dbValue.get(Configurator.DB_SERVER) + "/" + dbValue.get(Configurator.DB_INSTANCE);
		conn = DriverManager.getConnection(URL, dbValue.get(Configurator.DB_USERNAME), dbValue.get(Configurator.DB_PASSWORD));
		return conn;
	}
	
	/**
	 * Release all resources
	 * @param rs
	 * @param state
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement state, Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(state != null){
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Connection conn = DBHelper.getConnection();
		if(conn != null){
			System.out.println("Successfull!");
		}
	}
	
	

}

