<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "java.util.List" %>
<%@ page import = "com.jsp.demo.CategoryDAO" %>
<%@ page import = "com.jsp.demo.Category" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<!-- productname, categoryid, unitprice, unitsinstock -->
<form method="post" action="productAdd">
	<table>
		<tr>
			<td>
				Product Name:
			</td>
			
			<td>
				<input type="text" name="pname" id="pname">
			</td>
			
			<td>
				<span id="errPname" style="display:none"></span>
			</td>
		</tr>
		<tr>
			<td>
				Price:
			</td>
			
			<td>
				<input type="number" name="price" id="price">
			</td>
			
			<td>
				<span id="errPrice" style="display:none"></span>
			</td>
		</tr>
		
		<tr>
			<td>
				Units in stock:
			</td>
			
			<td>
				<input type="number" name="units" id="units">
			</td>
			
			<td>
				<span id="errUnits" style="display:none"></span>
			</td>
		</tr>
		
		<tr>
			<td>
				Category Name:
			</td>
			
			<td>
				<select id="category" name="category">
					<%
						CategoryDAO categoryDAO = new CategoryDAO();
					
						List<Category> categories = categoryDAO.getCategories();
						
						for(Category category : categories){
					%>
							<option value=<%= category.getId() %>><%= category.getName() %></option>
					<%	
						}
						
					%>
					
				
				</select>
			</td>
			
			<td>
				<span id="errUnits" style="display:none"></span>
			</td>
		</tr>
		
		<tr>
			<td>
				<input type="submit" value="Save">
			</td>
			
			<td>
				<input type="reset" value="Cancel">
			</td>
			
			<td>
				
			</td>
		</tr>
	</table>
</form>
</body>
</html>