package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.serigrafiado;
import util.ConexionMySql;

public class SerigrafiadoAction {

	// Definir los métodos que interactuarán con la BD:
	// insertar, eliminar, listar, actualizar, buscarXId

	public int ingresarSerigrafiado(serigrafiado s) {
		int salida = 0;

		// 1. Declarar variables
		Connection conn = null;
		PreparedStatement pstm = null;

		// 2. Control de excepciones
		try {
			// 3. Definir la sentencia SQL
			String sql = "INSERT INTO tb_serigrafiado VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

			// 4. Obtener la conexion
			conn = new ConexionMySql().getConexion();

			// 5. Obtener un PreparedStatement de la conexión
			pstm = conn.prepareStatement(sql);

			// 6. Agregar parametros
			pstm.setInt(1, s.getInsumo());
			pstm.setInt(2, s.getCantSalida());
			pstm.setString(3, s.getGuiaSalida());
			pstm.setInt(4, s.getCantIngreso());
			pstm.setString(5, s.getGuiaIngreso());
			pstm.setInt(6, s.getMerma());
			pstm.setString(7, s.getFecha());

			// 7. Ejecutar
			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexion y otros objetos
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return salida;

	}

	public ArrayList<serigrafiado> ListarSerigrafiado(serigrafiado serigrafiado) {
		ArrayList<serigrafiado> lista = new ArrayList<serigrafiado>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			cn = new ConexionMySql().getConexion();
			String sql = "SELECT * FROM tb_serigrafiado";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				serigrafiado obj = new serigrafiado(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8));

				lista.add(obj);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return lista;
	}

	public ArrayList<serigrafiado> obtener(String id) {
		ArrayList<serigrafiado> lista = new ArrayList<serigrafiado>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM tb_serigrafiado s join tb_insumo i on s.insumo = i.id_insumo WHERE descripcion = ?";
			cn = new ConexionMySql().getConexion();
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			
			while (rs.next()) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public int eliminar(int id) {
		int salida = -1;

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			String sql = "DELETE FROM tb_administrado WHERE idadministrado = ?";

			conn = new ConexionMySql().getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return salida;
	}

	/**
	 * public int actualizar(Administrado obj){ int salida = 0;
	 * 
	 * // 1. Declarar variables Connection conn = null; PreparedStatement pstm =
	 * null;
	 * 
	 * // 2. Control de excepciones try { // 3. Definir la sentencia SQL String sql
	 * = "UPDATE tb_administrado SET " + " nombres = ?, apellidos = ?, dni = ?, " +
	 * " direccion = ?, telefono = ?, " + " email = ?, distrito = ?, " + " fecha= ?"
	 * + " WHERE idadministrado = ?";
	 * 
	 * // 4. Obtener la conexion conn = MySqlDBConexion.getConexion();
	 * 
	 * // 5. Obtener un PreparedStatement de la conexión pstm =
	 * conn.prepareStatement(sql);
	 * 
	 * // 6. Agregar parametros pstm.setString(1, obj.getNombres());
	 * pstm.setString(2, obj.getApellidos()); pstm.setString(3, obj.getDni());
	 * pstm.setString(4, obj.getDireccion()); pstm.setString(5, obj.getTelefono());
	 * pstm.setString(6, obj.getEmail()); pstm.setString(7, obj.getDistrito());
	 * pstm.setString(8, obj.getFechaIngres()); pstm.setInt(9,
	 * obj.getIdadministrado());
	 * 
	 * 
	 * 
	 * // 7. Ejecutar salida = pstm.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally{ // Cerrar la conexion
	 * y otros objetos try { if(pstm != null) pstm.close(); if(conn != null)
	 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } } return
	 * salida; }
	 * 
	 * 
	 */

}
