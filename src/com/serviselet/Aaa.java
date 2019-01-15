package com.serviselet;

import java.awt.geom.GeneralPath;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserInfoDao;
import com.pojo.UserInfo;
import com.util.GenerateUUID;

@WebServlet("/Aaa")
public class Aaa extends HttpServlet {
	
	public Aaa() {
		super();
	}

	
	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String name = request.getParameter("name");
		System.out.println(name);
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("user");
		//System.out.println(name);
		String password = request.getParameter("password");
		//System.out.println(password);
		UserInfo info  = new UserInfo(GenerateUUID.getUUID(),name,password,"李四", 25);
	//	System.out.println(info);
		UserInfoDao dao = new UserInfoDao();
		//System.out.println(dao);
		//dao.text();
		dao.inertUserInfo(info);
		
		/*;
		info*/
		
	}



}
