package com.jsp.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
        super();
        
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
		
		String categoryName = request.getParameter("name");
		String description = request.getParameter("description");
		
		if(categoryName == null) {
			response.getWriter().println("<h1 style='color:red'>Some problem happened</h1>");
			response.getWriter().println("<a href='categories.jsp'>Categories</a>");
			return;
		}
			
		
		Category category = new Category(categoryName, description);
		
		CategoryDAO categoryDAO = new CategoryDAO();
		
		if(categoryDAO.insert(category)) {
			response.getWriter().println("<h1 style='color:green'>Category added successfully</h1>");
			response.getWriter().println("<a href='categories.jsp'>Categories</a>");
		}
		else {
			response.getWriter().println("<h1 style='color:red'>Some problem happened</h1>");
			response.getWriter().println("<a href='categories.jsp'>Categories</a>");
		}
	}

}
