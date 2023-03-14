package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.insumo;
import entidad.serigrafiado;
import util.ConexionMySql;

/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.serigrafiado;
import util.ConexionMySql;
*/
public class SerigrafiadoAction {

	// Definir los métodos que interactuarán con la BD:
		// insertar, eliminar, listar, actualizar, buscarXId
		
		public int ingresarSerigrafiado(serigrafiado s){
		int ingresar = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = new ConexionMySql().getConexion();
			
			cn.setAutoCommit(false);
			
			String sql = "INSERT INTO tb_serigrafiado VALUES (null, ?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, s.getInsumo());
			
			ingresar = pstm.executeUpdate();
			
			cn.commit();
			
			
		} catch (SQLException e) {
			try {
				cn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ingresar;
	}
	
	public ArrayList<insumo> listarInsumo(insumo insumo){
		ArrayList<insumo> lista = new ArrayList<insumo>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			
			cn = new ConexionMySql().getConexion();
			String sql = "SELECT * FROM tb_insumo;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				insumo obj = new insumo(rs.getInt(1), 
									rs.getString(2));
				
				lista.add(obj);
			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null)
					rs.close();
				if(pstm != null)
					pstm.close();
				if(cn != null)
					cn.close();
			}catch(Exception e2){
				e2.printStackTrace();
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


















