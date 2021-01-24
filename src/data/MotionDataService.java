package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.MotionSensor;
import beans.User;
import util.DatabaseException;

public class MotionDataService {

	public MotionDataService() {
		
	}
	
	public MotionSensor findById(int id) {
		return null;
	}

    /**
     * CRUD: finder to return all entities
     */
    public List<MotionSensor> findAll() {
		// DB Connection Info
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst361";
		String username = "admin";
		String password = "root";
		
		// Get all Motion Sensors
		List<MotionSensor> sensors = new ArrayList<MotionSensor>();
		try {
			// Connect to the Database
			conn = DriverManager.getConnection(url, username, password);
			
			// Execute SQL Query and loop over result set
			String sql1 = "SELECT * FROM SENSOR";
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql1);
			
			MotionSensor sensor = new MotionSensor(rs1.getString("NAME"), rs1.getBoolean("MOTION_DETECTED"), rs1.getDate("DATE"));
			
				
			// Add user to the return list
			sensors.add(sensor);
			
			
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
		
		// Return list of Motion Sensors
		return sensors;
    }

    /**
     * CRUD: finder to return a single entity
     */
	public MotionSensor findBy(User user) {
		// DB Connection Info
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst361";
		String username = "admin";
		String password = "root";
		
		MotionSensor sensor = new MotionSensor();
		
		// Get all Sensors
		try {
			// Connect to the Database
			conn = DriverManager.getConnection(url, username, password);
			
			// Execute SQL Query and loop over result set
			String sql1 = String.format("SELECT * FROM USER WHERE FIRST_NAME='%S' AND LAST_NAME='%S' AND EMAIL='%S' AND PASSWORD='%S'", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql1);
			
			String sql2 = String.format("SELECT * FROM SENSOR WHERE USER_ID=%d", rs1.getInt("ID"));
			Statement stmt2 = conn.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			
			// Get the User
			// TODO: Update SQL statement
			sensor.setName(rs2.getString("NAME"));
			sensor.setMotionDetected(rs2.getBoolean("MOTION_DETECTED"));
			sensor.setDetectedAt(rs2.getDate("DATE"));
			
			// Cleanup
			rs1.close();
			stmt1.close();
			rs2.close();
			stmt2.close();
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
		return sensor;
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
