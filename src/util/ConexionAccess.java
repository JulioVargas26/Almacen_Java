package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionAccess {
	public Connection getConexion(){
		Connection cn = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			cn = DriverManager.getConnection("jdbc:ucanaccess://D:\\Documentos\\Eclipse Java\\Basa\\Almacen_sql\\db\\basa_access.accdb");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e2){
			e2.printStackTrace();
		}
		return cn;
	}
}
