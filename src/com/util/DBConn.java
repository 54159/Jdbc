package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	public static Connection getConnection(){
		Connection conn =null;
//		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String url="jdbc:mysql://119.23.237.174:3306/my_db?characterEncoding=UTF8";
//		String user ="scott";
//		String password ="Cui123456";
		String user ="aaa";
		String password ="newpassword";
		
		try {
			//������������
//			Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ⣬�������ݿ����
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	
	public static void close(Connection conn,PreparedStatement pre,ResultSet res){
		try {
			if(conn!=null)
			conn.close();
			if(pre!=null)
				pre.close();
			if(res!=null){
				res.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



public static void main(String[] args) {
	
	
	System.out.println(DBConn.getConnection());
}
}
