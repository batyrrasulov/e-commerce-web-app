package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.*;

@Table("Products")
public class ProductEntity {
	@Id
	private long productID;
	
	@Column("Name")
	private String name;
	
	@Column("Quantity")
	private int quantity;
	
	@Column("Price")
	private float price;
	
	@Column("Description")
	private String description;
	
	@Column("Category")
	private String category;
	
	public ProductEntity(long productID, String name, int quantity, float price, String description,String category)
	{
		this.productID = productID;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
