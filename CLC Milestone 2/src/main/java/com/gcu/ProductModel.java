package com.gcu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class ProductModel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message="User name is a required field")
	@Size(min=1, max=32, message="User name must be between 1 and 32 characters")
	private String name;
	
	@NotNull(message="Quantity is a required field")
	@PositiveOrZero(message = "The value must be a number and greater than or equal to 0")
	private int quantity;
	
	@NotNull(message="Description is a required field")
	@Size(min=1, max=200, message="Description must be between 1 and 200 characters")
	private String description;
	
	@NotNull(message="Price is a required field")
	@PositiveOrZero(message = "The value must be a number and greater than or equal to 0")
	private float price;
	
	@NotNull(message="Category is a required field")
	@Size(min=1, max=32, message="Category must be between 1 and 32 characters")
	private String category;

	public ProductModel()
	{
		
	}
	public ProductModel(long id, String name, int quantity, String description, float price, String category)
	{
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	public long getProductID() {
		return 0;
	}
	
	
}
