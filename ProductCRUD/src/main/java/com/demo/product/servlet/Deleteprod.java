package com.demo.product.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class Deleteprod
 */
@WebServlet("/deleteprod")
public class Deleteprod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		ProductService eservice=new ProductServiceImpl();
		eservice.deleteprodbyid(pid);
		RequestDispatcher rd=request.getRequestDispatcher("/products");
		rd.forward(request, response);
				
	}

}
