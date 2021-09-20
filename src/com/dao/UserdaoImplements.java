package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.configuration.ConnectionFactory;
import com.model.User;

public class UserdaoImplements implements UserDao{

	ConnectionFactory connectionFactory;
	public UserdaoImplements() {
		// TODO Auto-generated constructor stub
		connectionFactory=new ConnectionFactory();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		 Connection connection = null;
		try {
			connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id);
            if(rs.next())
            {
            	 return extractUserFromResultSet(rs);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	    return null;
	}
	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
	    User user = new User();
	    user.setId( rs.getInt("id") );
	    user.setName( rs.getString("name") );
	    user.setPass( rs.getString("password") );
	    user.setAge( rs.getInt("age") );
	    return user;
	}
	public User getUserByUserNameAndPassword(String user, String pass)  {
	    
		
	    try {
	    	Connection connection = connectionFactory.getConnection();
	        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE name=? AND passsword=?");
	        ps.setString(1, user);
	        ps.setString(2, pass);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next())
	        {
	        	return extractUserFromResultSet(rs);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	@Override
	public Set<User> getAllUsers() {
		// TODO Auto-generated method stub
	
		
		    try {
		    	Connection connection = connectionFactory.getConnection();
		        Statement stmt = connection.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
		        Set<User> users = new HashSet<>();
		        while(rs.next())
		        {
		            User user = extractUserFromResultSet(rs);
		            users.add(user);
		        }
		        return users;
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return null;
	}

	

	@Override
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
	
	    try {
	    	Connection connection = connectionFactory.getConnection();
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?)");
	        ps.setInt(1, user.getId());
	        ps.setString(2, user.getName());
	        ps.setString(3, user.getPass());
	        ps.setInt(4, user.getAge());
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		
		    try {
		    	Connection connection = connectionFactory.getConnection();
		        PreparedStatement ps = connection.prepareStatement("UPDATE users SET name=?, passsword=?, age=? WHERE id=?");
		        ps.setString(1, user.getName());
		        ps.setString(2, user.getPass());
		        ps.setInt(3, user.getAge());
		        ps.setInt(4, user.getId());
		        int i = ps.executeUpdate();
		      if(i == 1) {
		    return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		 
		    try {
		    	Connection connection = connectionFactory.getConnection();
		        Statement stmt = connection.createStatement();
		        int i = stmt.executeUpdate("DELETE FROM users WHERE id=" + id);
		      if(i == 1) {
		    return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return false;
	}

}
