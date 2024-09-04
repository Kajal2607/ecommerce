<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<form method="post" action="edit">
		<table>
			<tr>
				<td>Id</td>
				<td>
					<%
						String id = request.getParameter("id");
						String name = request.getParameter("name");
						String description = request.getParameter("description");
					%>
					<input type="text" name="catid" id="catid" value="<%= id %>" readonly>
				</td>
			</tr>
			
			<tr>
				<td>Name</td>
				<td>
					<input type="text" name="catname" id="catname" value="<%= name %>" >
				</td>
			</tr>
			
			<tr>
				<td>Description</td>
				<td>
					<input type="text" name="catdescription" id="catdescription" value="<%= description%>">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="Update">
				</td>
				<td>
					<input type="reset" value="Cancel">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>