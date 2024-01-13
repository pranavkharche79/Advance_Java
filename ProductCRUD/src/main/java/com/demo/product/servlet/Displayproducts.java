package com.demo.product.servlet;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.demo.model.MyUser;
import com.demo.model.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.mysql.cj.Session;

/**
 * Servlet implementation class Displayproducts
 */
@WebServlet("/products")
public class Displayproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService eservice=new ProductServiceImpl();
//		HttpSession ses=(HttpSession)request.getAttribute("session");
//		MyUser user=(MyUser)ses.getAttribute("user");
//		System.out.println(user.getRole());
		
		List<Product> lst=eservice.getallproducts();
		request.setAttribute("lst", lst);
		RequestDispatcher rd= request.getRequestDispatcher("displayproducts.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
