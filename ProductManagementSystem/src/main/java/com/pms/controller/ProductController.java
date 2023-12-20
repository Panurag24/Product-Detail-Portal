package com.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pms.entity.Products;
import com.pms.service.ProductService;


/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ProductService ps = new ProductService();
		List<Products> listOfProduct = ps.findAllProduct();
		
		HttpSession hs = request.getSession();
		hs.setAttribute("products", listOfProduct);
		
		response.sendRedirect("displayProduct.jsp");
		response.setContentType("text/html");
		
    	
    	
	}
    
    
    
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter pw = response.getWriter();				// object created. 

		// created service class object. 
		ProductService ps = new ProductService();
		
		// receive the value from form 
		
		String operation = request.getParameter("operation");
		
		if(operation.equals("add")) {
		String pname = request.getParameter("pname");
		float price = Float.parseFloat(request.getParameter("price"));
		String url = request.getParameter("url");
		
		// convert those value to objects. 
		
		Products p = new Products();
		p.setPname(pname);
		p.setPrice(price);
		p.setUrl(url);
		

		String result = ps.storeProduct(p);
		pw.print(result);
		RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
		rd.include(request, response);
		
		}else if(operation.equals("delete")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			String result = ps.deleteProduct(pid);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("deleteProduct.jsp");
			rd.include(request, response);
		}
		
		
		response.setContentType("text/html");
		
	}

}
