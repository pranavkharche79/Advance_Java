package com.demo.Login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		LoginService ls= new LoginServiceImpl();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		MyUser user=ls.validate(uname,pass);
		if(user!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			if(user.getRole().equals("admin"))
			{
				RequestDispatcher rd= request.getRequestDispatcher("products");
				rd.forward(request, response);
			}
			else 
			{
				String a="You are a User";
				request.setAttribute("s", a);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
		}
		else {
			String s="Wrong credentials, pls renter";
			request.setAttribute("s", s);
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		
		
	}

}
