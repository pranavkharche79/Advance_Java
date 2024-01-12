package com.demo.product.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/update")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		String title=request.getParameter("title");
		String desc=request.getParameter("desc");
		int price=Integer.parseInt(request.getParameter("price"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		int stock=Integer.parseInt(request.getParameter("stock"));
		Product p= new Product(pid,title,desc,price,cid,stock);
		ProductService eservice=new ProductServiceImpl();
		eservice.updateproduct(p);
		RequestDispatcher rd= request.getRequestDispatcher("/products");
		rd.forward(request, response);
	}

}
