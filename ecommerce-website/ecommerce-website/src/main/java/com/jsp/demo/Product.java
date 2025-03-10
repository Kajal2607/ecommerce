package com.jsp.demo;

public class Product {
	private int id;
	private String name;
	private double price;
	private int units;
	private int categoryId;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, double price, int units) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.units = units;
	}
	
	public Product(String name, double price, int units) {
		super();
		
		this.name = name;
		this.price = price;
		this.units = units;
	}
	
	public Product(String name, double price, int units, int categoryId) {
		super();
		
		this.name = name;
		this.price = price;
		this.units = units;
		this.categoryId = categoryId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
		
	public int getCategoryId() {
		return categoryId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", units=" + units + "]";
	}
	
	
}
