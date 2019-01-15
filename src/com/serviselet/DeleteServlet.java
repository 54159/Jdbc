package com.serviselet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserInfoDao;
import com.pojo.UserInfo;
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid"); 
		UserInfo user = new UserInfo(userid,null, null, null, null);
		UserInfoDao dao = new UserInfoDao();
		dao.delete(user);
		response.sendRedirect("SelectServlet");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
