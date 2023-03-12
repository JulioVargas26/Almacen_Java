package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.serigrafiado;
import util.MySqlDBConexion;

public class SerigrafiadoAction {

	// Definir los métodos que interactuarán con la BD:
		// insertar, eliminar, listar, actualizar, buscarXId
		
		public int insertar(serigrafiado obj){
			int salida = 0;
			
			// 1. Declarar variables
			Connection conn = null;
			PreparedStatement pstm = null;
			
			// 2. Control de excepciones
			try {
				// 3. Definir la sentencia SQL
				String sql = "INSERT INTO tb_serigrafiado VALUES (null, ?,?,?,?,?,?,?)";
				
				// 4. Obtener la conexion
				conn = MySqlDBConexion.getConexion();
				
				// 5. Obtener un PreparedStatement de la conexión
				pstm = conn.prepareStatement(sql);
				
				// 6. Agregar parametros
				pstm.setInt(1, obj.getInsumo());
				pstm.setString(2, obj.getFecha());
				pstm.setInt(3, obj.getCantSalida());
				pstm.setString(4, obj.getGuiaSalida());	
				pstm.setInt(5, obj.getCantIngreso());
				pstm.setString(6, obj.getGuiaIngreso());
				pstm.setInt(7, obj.getMerma());	
				
				// 7. Ejecutar
				salida = pstm.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				// Cerrar la conexion y otros objetos
				try {
					if(pstm != null)
						pstm.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return salida;		
		}

		public List<serigrafiado> listar(){
			List<serigrafiado> lista = new ArrayList<serigrafiado>();
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				// 1. Definir la sentencia SQL
				String sql = "SELECT * FROM tb_serigrafiado";
				
				// 2. Obtener la conexion
				conn = MySqlDBConexion.getConexion();
				
				// 3. Obtener el PreparedStatement
				pstm = conn.prepareStatement(sql);
				
				// 4. Ejecutamos y obtenemos el ResultSet
				rs = pstm.executeQuery();
				
				// 5. Poblar la coleccion
				serigrafiado obj = null;
				// Recorre el rs
				while (rs.next()) {
					obj = new serigrafiado();
					obj.setFecha(rs.getString("fecha"));
					obj.setCantSalida(rs.getInt("cantSalida"));
					obj.setGuiaSalida(rs.getString("guiaSalida"));
					obj.setCantIngreso(rs.getInt("cantIngreso"));
					obj.setGuiaIngreso(rs.getString("guiaIngreso"));					
					obj.setMerma(rs.getInt("merma"));
				
					// Agregar a la lista
					lista.add(obj);
				}			
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					if(rs != null)
						rs.close();
					if(pstm != null)
						pstm.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return lista;
		}
		
		/**public int eliminar(int id){
			int salida = -1;
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				String sql = "DELETE FROM tb_administrado WHERE idadministrado = ?";
				
				conn = MySqlDBConexion.getConexion();
				
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				
				salida = pstm.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					if(pstm != null)
						pstm.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return salida;
		}
		
		public Administrado obtener(int id){
			Administrado obj = null;
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM tb_administrado WHERE idadministrado = ?";
				conn = MySqlDBConexion.getConexion();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				rs = pstm.executeQuery();
				while (rs.next()) {
					obj = new Administrado();
					obj.setIdadministrado(rs.getInt("idadministrado"));
					obj.setNombres(rs.getString("nombres"));
					obj.setApellidos(rs.getString("apellidos"));
					obj.setDni(rs.getString("dni"));	
					obj.setDireccion(rs.getString("direccion"));	
					obj.setTelefono(rs.getString("telefono"));
					obj.setEmail(rs.getString("email"));
					obj.setDistrito(rs.getString("distrito"));
					obj.setFechaIngres(rs.getString("fecha"));
				
				}		
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					if(rs != null)
						rs.close();
					if(pstm != null)
						pstm.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return obj;
		}
		
		public int actualizar(Administrado obj){
			int salida = 0;
			
			// 1. Declarar variables
			Connection conn = null;
			PreparedStatement pstm = null;
			
			// 2. Control de excepciones
			try {
				// 3. Definir la sentencia SQL
				String sql = "UPDATE tb_administrado SET "
						+ " nombres = ?, apellidos = ?, dni = ?, "
						+ " direccion = ?, telefono = ?, "
						+ " email = ?, distrito = ?, "
						+ " fecha= ?"
						+ " WHERE idadministrado = ?";
				
				// 4. Obtener la conexion
				conn = MySqlDBConexion.getConexion();
				
				// 5. Obtener un PreparedStatement de la conexión
				pstm = conn.prepareStatement(sql);
				
				// 6. Agregar parametros
				pstm.setString(1, obj.getNombres());
				pstm.setString(2, obj.getApellidos());
				pstm.setString(3, obj.getDni());
				pstm.setString(4, obj.getDireccion());
				pstm.setString(5, obj.getTelefono());
				pstm.setString(6, obj.getEmail());
				pstm.setString(7, obj.getDistrito());
				pstm.setString(8, obj.getFechaIngres());
				pstm.setInt(9, obj.getIdadministrado());
				
			
				
				// 7. Ejecutar
				salida = pstm.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				// Cerrar la conexion y otros objetos
				try {
					if(pstm != null)
						pstm.close();
					if(conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return salida;		
		}
		
		
*/

	}


















