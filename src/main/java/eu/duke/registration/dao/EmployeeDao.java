package eu.duke.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import eu.duke.registration.model.Employee;

public class EmployeeDao {
	// CONNECTION THROUGH JDBC TO MYSQL
	
	public int registorEmployee(Employee emp) throws ClassNotFoundException {
		
		int result = 0;
		String INSERT_SQL =  "INSERT INTO employee"
				+ "(id, first_name, last_name, username, password, address, contact) VALUES"
				+ "(?,?,?,?,?,?,?);";
				
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false",
				"root", "root")) {
			PreparedStatement  ps = con.prepareStatement(INSERT_SQL);
			ps.setInt(1, 1);
			ps.setString(2, emp.getFirstName());
			ps.setString(3, emp.getLastName());
			ps.setString(4, emp.getUserName());
			ps.setString(5, emp.getPassword());
			ps.setString(6, emp.getAddress());
			ps.setString(7, emp.getContact());
			
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch( SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
