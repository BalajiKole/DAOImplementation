package com.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dao.BookDaoImplementation;
import com.dao.UserdaoImplements;
import com.model.Book;
import com.model.User;
import com.service.BookService;
import com.service.BookServiceImplementation;
import com.service.UserService;
import com.service.UserServiceImplementation;

public class Client {

	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	
		//BookDaoImplementation bookDaoImplementation=new BookDaoImplementation();
		
		//BookService bookService=new BookServiceImplementation(bookDaoImplementation);
		BookService bookService=new BookServiceImplementation();
		List<Book> bookList=bookService.getAllBooks();
		Iterator<Book> itr=bookList.iterator();
		System.out.println("**********   All book details ***************");
		while (itr.hasNext()) {
			Book book = (Book) itr.next();
			System.out.println("Book Id:- "+ book.getBookId());
			System.out.println("Book Title:- "+ book.getTitle());
			System.out.println("Book Author:- "+ book.getAuthor());
			System.out.println("Book price:- "+ book.getPrice());
			System.out.println("**************************************");
			
		}
		System.out.println(" ");
		System.out.println("******* Enter book information ************");
		System.out.println("Enter book Id:- ");
		int bookId=scanner.nextInt();
		System.out.println("Enter book title:- ");
		String bookTitle=scanner.next();
		System.out.println("Enter book author:- ");
		String bookAuthor=scanner.next();
		System.out.println("Enter book price:- ");
		int bookPrice=scanner.nextInt();
		
		Book book=new Book(bookId,bookTitle,bookAuthor,bookPrice);
		
	    int status=bookService.addBook(book);
	    if(status>0) {
	    	System.out.println("Book added sucessfully.....");
	    }else {
	    	System.out.println("Unable to add book.........");
	    }
	    
	}
}
