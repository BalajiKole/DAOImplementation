package com.model;

public class Book {
	int bookId;
	String title;
	String Author;
	int price;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(int bookId, String title, String author, int price) {
		this.bookId = bookId;
		this.title = title;
		Author = author;
		this.price = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "[bookId=" + bookId + ", title=" + title + ", Author=" + Author + ", price=" + price + "]";
	}
	
	

}
