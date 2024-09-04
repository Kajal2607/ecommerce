package com.jsp.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCategoryServlet
 */
@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategoryServlet() {
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
		int id = Integer.parseInt(request.getParameter("catid"));
		/*
		String categoryName = request.getParameter("catname");
		String description = request.getParameter("catdescription");
		*/
		
		
		//Category category = new Category(id, categoryName, description);
		
		CategoryDAO categoryDAO = new CategoryDAO();
		
		if(categoryDAO.delete(id)) {
			response.getWriter().println("<h1 style='color:green'>Category deleted successfully</h1>");
			response.getWriter().println("<a href='categories.jsp'>Categories</a>");
		}
		else {
			response.getWriter().println("<h1 style='color:red'>Some problem happened</h1>");
			response.getWriter().println("<a href='categories.jsp'>Categories</a>");
		}
	}
}
