package com.service;

import java.util.List;

import com.dao.BooKDao;
import com.dao.BookDaoImplementation;
import com.model.Book;

public class BookServiceImplementation implements BookService {
	
 BooKDao booKDao;
 
 public BookServiceImplementation() {
	// TODO Auto-generated constructor stub
	 booKDao=new BookDaoImplementation();
}
	public BookServiceImplementation(BooKDao booKDao) {
	this.booKDao = booKDao;
}
	

	public BooKDao getBooKDao() {
		return booKDao;
	}


	public void setBooKDao(BooKDao booKDao) {
		this.booKDao = booKDao;
	}


	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return booKDao.getAllBooks();
	}
	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		return booKDao.addBook(book);
	}
	
}
