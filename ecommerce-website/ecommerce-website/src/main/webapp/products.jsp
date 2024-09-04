<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page import="java.util.List" %>
<%@ page import="com.jsp.demo.Product" %>
<%@ page import="com.jsp.demo.ProductDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<%
		
	ProductDAO productDAO = new ProductDAO();
	List<Product> products = null;
		
	if(request.getParameter("id") != null){
		int id = Integer.parseInt(request.getParameter("id").toString());
		
		products = productDAO.getProducts(id);
	}
	else {
		int p;
		
		if(request.getParameter("page") == null)
			p=1;
		else
		 	p = Integer.parseInt(request.getParameter("page").toString());
		
		
		int f=0;
		
		if(p==1)
			f=1;
		else if(p==2)
			f=11;
		else if(p==3)
			f=21;
		else if(p==4)
			f=31;
		else if(p==5)
			f=41;
		else if(p==6)
			f=51;
		else if(p==7)
			f=61;
		else if(p==8)
			f=71;
		
			
		products = productDAO.getProducts(f,10);
	}
	%>
	<table border="0">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Stock</th>
		</tr>
		
		<%
			//for(int i=0; i<categories.size(); i++)
			for(Product product:products){
				out.println("<tr><td>" + product.getId() + "</td>");
				out.println("<td>" + product.getName() + "</td>");
				out.println("<td>" + product.getPrice() + "</td>");
				out.println("<td>" + product.getUnits() + "</td></tr>");
			}
				
		%>
	</table>
	<br/>
	<%
		int count = productDAO.getProductCount();
		int nPages = count/10 + 1;
		//out.print(count);
		for(int i=1; i<=nPages; i++){
	 %>
	 	<a href=products.jsp?page=<%= i %>><%= i %></a>&nbsp;&nbsp;
	 
	<%	}
		
	%>
	
</body>
</html>