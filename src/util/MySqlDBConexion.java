package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConexion {

	// Cargar la librería al iniciar la aplicación
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Metodo para obtener la conexión
	public static Connection getConexion(){
		Connection conn = null;
		
		// Se obtiene la conexion con la ruta del servicio+bd, 
		// usuario y clave
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/basa",
					"root", "mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}





















