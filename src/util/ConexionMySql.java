package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {
	public Connection getConexion(){
		Connection cn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basa","root", "mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e2){
			e2.printStackTrace();
		}
		return cn;
	}
}
