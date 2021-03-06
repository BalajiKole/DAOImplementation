package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configuration.ConnectionFactory;
import com.model.Book;

public class BookDaoImplementation implements BooKDao {
	// ConnectionFactory ConnectionFactory;

	public BookDaoImplementation() {

		// ConnectionFactory = new ConnectionFactory();
	}

	@Override
	public List<Book> getAllBooks() {
		ArrayList<Book> bookList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String QUERY = "select * from book";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(QUERY);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setBookId(resultSet.getInt("book_id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setPrice(resultSet.getInt("price"));
			//Book book = new Book(resultSet.getInt("book_id"),resultSet.getString("title"),resultSet.getString("author"),resultSet.getInt("price"));
				bookList.add(book);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bookList;
	}

	@Override
	public int addBook(Book book) {
		System.out.println(book);
		int status = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("insert into book values(?,?,?,?)");
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setInt(4, book.getPrice());
			status=preparedStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
				try {
					if(preparedStatement!=null)
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if(connection!=null)
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// TODO Auto-generated method stub
		return status;
	}
	
	
}
