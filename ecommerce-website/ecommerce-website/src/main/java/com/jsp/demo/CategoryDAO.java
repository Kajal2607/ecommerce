package com.jsp.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	public List<Category> getCategories(){
		
		Connection con = null;
		List<Category> categories = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
			
			String query = "select categoryid, categoryname, description from categories";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			categories = new ArrayList<>();
			
			while(rs.next()) {
				Category category = new Category();
				
				category.setId(rs.getInt("CategoryID"));
				category.setName(rs.getString("categoryname"));
				category.setDescription(rs.getString("Description"));
				
				categories.add(category);
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return categories;
				
	}
	
	public boolean insert(Category category) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
			
			String insertCategory = "insert categories(categoryName, description) values('" + category.getName() + "','" + category.getDescription() + "');";
			
			System.out.println(insertCategory);
			
			Statement stmt = con.createStatement();
			
			int row = stmt.executeUpdate(insertCategory);
			
			if(row > 0)
				return true;
			else
				return false;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
		
	}

	public boolean update(Category category) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
			
			String updateCategory = "update categories set categoryname='" + category.getName() + "',description='" + category.getDescription() + "' where categoryid= " + category.getId();
			
			
			//System.out.println(insertCategory);
			
			Statement stmt = con.createStatement();
			
			/*
			PreparedStatement pstmt = con.prepareStatement(updateCategory);
			pstmt.setString(1, category.getName());
			pstmt.setString(2, category.getDescription());
			pstmt.setInt(3, category.getId());
			*/
			int row = stmt.executeUpdate(updateCategory);
			
			if(row > 0)
				return true;
			else
				return false;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
		
	}
	
	public boolean delete(int categoryid) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
			
			String deleteCategory = "delete from categories where categoryid=" + categoryid;
			
			
			
			
			Statement stmt = con.createStatement();
			
			
			int row = stmt.executeUpdate(deleteCategory);
			
			if(row > 0)
				return true;
			else
				return false;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null)
					con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
}
