package com.serviselet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserInfoDao;
import com.pojo.UserInfo;
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserInfoDao dao = new UserInfoDao();
		List<UserInfo> list = dao.selectUserInfo();
		//System.out.println("select"+list);
	//	String a ="AA";
	//	request.setAttribute("a", a);
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
