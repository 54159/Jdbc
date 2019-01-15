package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.UserInfo;
import com.util.DBConn;
import com.util.GenerateUUID;
public class UserInfoDao {
	private Connection conn = null;

	// 往数据库中添加数据
	public void inertUserInfo(UserInfo info) {
		// 1.获得数据库的连接
		conn = DBConn.getConnection();
		// 2.编写sql语句
		//conn = null;
		
		// ?表示占位符:表示这个地方需要5个参数
		String sql = "insert into userinfo values(?,?,?,?,?)";
		// 3.预编译对象编译sql语句
		PreparedStatement pre = null ;
		try {
			// 编译sql语句
			 pre = conn.prepareStatement(sql);
			// 4.如果在编译sql的时候 有占位符 那么我们需要对占位符 赋值
			pre.setString(1, info.getUserID());
			pre.setString(2, info.getUserName());
			pre.setString(3, info.getUserPass());
			pre.setString(4, info.getRealName());
			pre.setInt(5, info.getUserAge());
			// 5.执行sql语句
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConn.close(conn,pre, null);
			
		}
		
	}
	
	
	//删除数据
	public void delete(UserInfo user){
		System.out.println(user.getUserID());
		Connection conn = DBConn.getConnection();
		String sql = "delete  userinfo where userid = ?";
		PreparedStatement pre = null;
		try {
			//conn.setAutoCommit(false);
			pre = conn.prepareStatement(sql);
			pre.setString(1, user.getUserID());
			pre.executeUpdate();
			//conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConn.close(conn, pre, null);
		}
		
	}
	
	
	
	
	
	// 查找数据库中的数据
		public List<UserInfo> selectUserInfo() {
			List<UserInfo> list =new ArrayList<UserInfo>();
			// 1.获得数据库的连接
			conn = DBConn.getConnection();
			
			ResultSet res ;
			// 2.编写sql语句
			// ?表示占位符:表示这个地方需要5个参数
			String sql = "select * from userinfo";
			// 3.预编译对象编译sql语句
			try {
				// 编译sql语句
				PreparedStatement pre = conn.prepareStatement(sql);
				// 4.执行sql语句
				res=pre.executeQuery();
				UserInfo info = null;
				while(res.next()){
				 info = new UserInfo(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5));
				 	list.add(info);
				}
				return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
			return null;
			
			
		}
		
		public void text() {
			System.out.println("haha");
		}
		
		public UserInfo login(UserInfo user){
			
			Connection conn=DBConn.getConnection();
			ResultSet res = null;
			String sql = "select * from userinfo where userName=? and userPass=?";
			try {
				PreparedStatement pre = conn.prepareStatement(sql);
				pre.setString(1, user.getUserName());
				pre.setString(2, user.getUserPass());
				 res = pre.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserInfo info = null;
			try {
				if(res.next()){
				info = new UserInfo(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5));
				}
				return info;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return null;
		}
		
		public static void main(String[] args) {
			UserInfoDao dao = new UserInfoDao();
			UserInfo info = new UserInfo(GenerateUUID.getUUID(), "lisi", "lisi123", "李四", 25);
			dao.inertUserInfo(info);
//			List<UserInfo> res = dao.selectUserInfo();
//			System.out.println(res);
			
			
		}
	
	
}
