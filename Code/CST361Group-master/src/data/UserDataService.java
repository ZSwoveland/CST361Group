package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import util.DatabaseException;

public class UserDataService {
	
	public UserDataService() {
		
	}
	
	public User findById(int id) {
		return null;
	}

    /**
     * CRUD: finder to return all entities
     */
    public List<User> findAll() {
		// DB Connection Info
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst361";
		String username = "admin";
		String password = "root";
		
		// Get all Users
		List<User> users = new ArrayList<User>();
		try {
			// Connect to the Database
			conn = DriverManager.getConnection(url, username, password);
			
			// Execute SQL Query and loop over result set
			String sql1 = "SELECT * FROM USER";
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql1);
			
			User user = new User(rs1.getString("FIRST_NAME"), rs1.getString("LAST_NAME"), rs1.getString("EMAIL"), rs1.getString("PASSWORD"));
			
				
			// Add user to the return list
			users.add(user);
			
			
			// Cleanup
			rs1.close();
			stmt1.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		finally
		{
			// Cleanup Database
			if(conn != null)
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new DatabaseException(e);
				}
			}
		}
		
		// Return list of Albums
		return users;
    }

    /**
     * CRUD: finder to return a single entity
     */
	public User findBy(User user) {
		// DB Connection Info
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst361";
		String username = "admin";
		String password = "root";
		
		// Get all Users
		try {
			// Connect to the Database
			conn = DriverManager.getConnection(url, username, password);
			
			// Execute SQL Query and loop over result set
			String sql1 = String.format("SELECT * FROM USER WHERE FIRST_NAME='%S' AND LAST_NAME='%S' AND EMAIL='%S' AND PASSWORD='%S'", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql1);
			
			if(!rs1.next()) {
				rs1.close();
				stmt1.close();
				return null;
			}
			
			// Get the User
			// TODO: Update SQL statement
			user.setFirstName(rs1.getString("FIRST_NAME"));
			user.setLastName(rs1.getString("LAST_NAME"));
			user.setEmail(rs1.getString("EMAIL"));
			user.setPassword(rs1.getString("PASSWORD"));
				
			// Cleanup
			rs1.close();
			stmt1.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		finally {
			// Cleanup Database
			if(conn != null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException(e);
				}
			}
		}
		
		// Return Albums
		return user;
	}

	/**
	 * CRUD: create an entity
	 */
	public boolean create(User user) {
		// DB Connection Info
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst361";
		String username = "admin";
		String password = "root";
		
		// Insert Album and Tracks
		try {
			// Connect to the Database
			conn = DriverManager.getConnection(url, username, password);

			// Insert an User
			// TODO: Update SQL Statement
			String sql1 = String.format("INSERT INTO  USER(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES('%s', '%s', '%s', '%s')", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
			Statement stmt1 = conn.createStatement();
			stmt1.executeUpdate(sql1);
			
			// Get Auto-Increment PK back
			String sql2= "SELECT LAST_INSERT_ID() AS LAST_ID FROM USER";
			ResultSet rs = stmt1.executeQuery(sql2);
			rs.next();
			String userId = rs.getString("LAST_ID");
			rs.close();
			stmt1.close();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		finally {
			// Cleanup Database
			if(conn != null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
					throw new DatabaseException(e);
				}
			}
		}
		
		// Return OK
		return true;
	}
	
	/**
	 * CRUD: update an entity
	 */
	public boolean update(User user) {
		return true;
	}
	
	/**
	 * CRUD: delete an entity
	 */
	public boolean delete(User user) {
		return false;
	}

}
