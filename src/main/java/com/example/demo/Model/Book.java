package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookNmae() {
		return bookNmae;
	}
	public void setBookNmae(String bookNmae) {
		this.bookNmae = bookNmae;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	private String bookNmae;
	public Book(int id, String bookNmae, float price, int quantity, String authorName) {
		super();
		this.id = id;
		this.bookNmae = bookNmae;
		this.price = price;
		this.quantity = quantity;
		this.authorName = authorName;
	}
	private float price;
	private int quantity;
	private String authorName;
	public Book() {
		
	}
	
}
