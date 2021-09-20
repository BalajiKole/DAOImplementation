package com.service;

import java.util.List;

import com.model.Book;

public interface BookService {
	List<Book> getAllBooks();
	int addBook(Book book);

}
