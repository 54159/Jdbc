package com.serviselet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dao.UserInfoDao;
import com.pojo.UserInfo;
import com.util.GenerateUUID;
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("user");
		String password = request.getParameter("password");
		UserInfo user = new UserInfo(GenerateUUID.getUUID(), username, password, null, null);
		UserInfoDao dao = new UserInfoDao();
		UserInfo user1=dao.login(user);
//		System.out.println(user1);
		HttpSession session = request.getSession();
		// 怎么去获得上下文
		ServletContext context = this.getServletContext();
		
		// 获得count的值
		String countstr = (String) context.getAttribute("count");
		if(user1!=null){


				int count = 0;
				if (countstr == null) {
					count = 1;
				} else {
					count = Integer.parseInt(countstr);
					count++;
				}
				context.setAttribute("count", count + "");
			
			
			session.setAttribute("dq", user1);
			
			response.sendRedirect("SelectServlet");}
		else{
//			System.out.println("cuole");
			request.setAttribute("error"," 账号或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
	}

	

}
