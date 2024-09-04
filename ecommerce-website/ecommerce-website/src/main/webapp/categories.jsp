<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page import="com.jsp.demo.CategoryDAO"%>
 <%@ page import="java.util.List" %>
 <%@ page import="com.jsp.demo.Category" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
	<script type="text/javascript">		
		function show(){
			//alert("Testing...");
			document.getElementById("addElement").style.display="none";
			document.getElementById("addCategory").style.display="flex";
		}
		
		
		
	</script>
</head>
<body>
	<%
		CategoryDAO categoryDAO = new CategoryDAO();
		List<Category> categories = categoryDAO.getCategories();
	%>
	<table border="0">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		
		<%
			//for(int i=0; i<categories.size(); i++)
			for(Category category:categories){
				out.println("<tr><td>" + category.getId() + "</td>");
				out.println("<td><a href='products.jsp?id=" + category.getId() + "'>" + category.getName() + "</a></td>");
				out.println("<td>" + category.getDescription() + "</td>");
				String value = "id=" + category.getId()+ "&name="+category.getName()+"&description="+ category.getDescription();
				//System.out.println(value);
				out.println("<td><a href='editcategory.jsp?" + value + "'>Edit</a></td>");
				out.println("<td><a href='deletecategory.jsp?" + value + "'>Delete</a></td></tr>");
			}	
		%>
	</table>
	<br/>
	<a href="#" id="addElement" onclick="show();">Add</a>
	<div id="addCategory" style="display:none">
		<%
		//out.println("<a href='#'>Add</a>");
		out.println("<form method='post' action='add'>");
		out.println("Category Name: <input type='text' name='name' id='name'>");
		out.println("</br></br>");
		out.println("Description: <input type='text' name='description' id='description'>");
		out.println("</br></br>");
		out.println("<input type='submit' value='Save'>");
		out.println("</form>");
	%>
	</div>
</body>
</html>