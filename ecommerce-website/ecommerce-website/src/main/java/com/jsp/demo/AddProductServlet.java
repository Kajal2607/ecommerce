package com.jsp.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("pname");
		double price = Double.parseDouble(request.getParameter("price").toString());
		int units = Integer.parseInt(request.getParameter("units").toString());
		int categoryId = Integer.parseInt(request.getParameter("category").toString());
		
		//System.out.println("Value: " + request.getParameter("category"));
		
		ProductDAO productDAO = new ProductDAO();
		
		Product product = new Product(productName, price, units, categoryId);
		
		if(productDAO.insert(product)) {
			response.getWriter().println("<h1 style='color:green'>Product added successfully</h1>");
			response.getWriter().println("<a href='products.jsp'>Products</a>");
		}
		else {
			response.getWriter().println("<h1 style='color:red'>Some problem happened</h1>");
			response.getWriter().println("<a href='products.jsp'>Products</a>");
		}
	}

}
