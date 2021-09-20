package com.dao;

import java.util.List;

import com.model.Book;

public interface BooKDao {
	List<Book> getAllBooks();
	int addBook(Book book);
}
