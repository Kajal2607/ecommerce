package com.jsp.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	public List<Product> getProducts(int first, int last){
			
			Connection con = null;
			List<Product> products=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
				
				String query = "select productid, productname, unitprice, unitsinstock from products where productid >= "+first+ " and productid <= " + (first+last-1);
				
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery(query);
				
				products = new ArrayList<>();
				
				while(rs.next()) {
					Product product = new Product();
					
					product.setId(rs.getInt("ProductID"));
					product.setName(rs.getString("productname"));
					product.setPrice(rs.getDouble("unitprice"));
					product.setUnits(rs.getInt("unitsinstock"));
					
					
					products.add(product);
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
			
			return products;
					
		}
	public List<Product> getProducts(){
			
			Connection con = null;
			List<Product> products=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
				
				String query = "select productid, productname, unitprice, unitsinstock from products";
				
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery(query);
				
				products = new ArrayList<>();
				
				while(rs.next()) {
					Product product = new Product();
					
					product.setId(rs.getInt("ProductID"));
					product.setName(rs.getString("productname"));
					product.setPrice(rs.getDouble("unitprice"));
					product.setUnits(rs.getInt("unitsinstock"));
					
					
					products.add(product);
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
			
			return products;
					
		}
	
	public List<Product> getProducts(int id){
		
		Connection con = null;
		List<Product> products=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
			
			String query = "select productid, productname, unitprice, unitsinstock from products where categoryid="+id;
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			products = new ArrayList<>();
			
			while(rs.next()) {
				Product product = new Product();
				
				product.setId(rs.getInt("ProductID"));
				product.setName(rs.getString("productname"));
				product.setPrice(rs.getDouble("unitprice"));
				product.setUnits(rs.getInt("unitsinstock"));
				
				
				products.add(product);
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
		
		return products;
				
	}
	
	public int getProductCount() {
		Connection con = null;
		List<Product> products=null;
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
			
			String query = "select productid from products";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
		
			
			
			while(rs.next()) {
				count++;
				
			}
			
			//System.out.println("Count: " + count);
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
		
		return count;
	}

	public boolean insert(Product product) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","mysql");
			
			String insertProduct = "insert products(productname, unitprice, unitsinstock, categoryid) values('" + product.getName() + "'," + product.getPrice() + "," + product.getUnits()  + "," + product.getCategoryId()+  ");";
			
			//System.out.println(insertProduct);
			
			Statement stmt = con.createStatement();
			
			int row = stmt.executeUpdate(insertProduct);
			
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
