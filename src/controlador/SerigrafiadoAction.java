package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.insumo;
import entidad.serigrafiado;
import util.ConexionAccess;

public class SerigrafiadoAction {

	// Definir los m�todos que interactuar�n con la BD:
	// insertar, eliminar, listar, actualizar, buscarXId

	public int IngresarSerigrafiado(serigrafiado s) {
		int salida = 0;

		// 1. Declarar variables
		Connection conn = null;
		PreparedStatement pstm = null;

		// 2. Control de excepciones
		try {
			// 3. Definir la sentencia SQL
			String sql = "INSERT INTO tb_serigrafiado VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

			// 4. Obtener la conexion
			conn = new ConexionAccess().getConexion();

			// 5. Obtener un PreparedStatement de la conexi�n
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

			cn = new ConexionAccess().getConexion();
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

	public List<insumo> ComboInsumo() {
		List<insumo> list = null;

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = new ConexionAccess().getConexion();

			// Definir la sentencia SQL
			String sql = "SELECT * FROM tb_insumo";

			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			list = new ArrayList<insumo>();
			while (rs.next()) {
				insumo pst = new insumo(rs.getInt(1), rs.getString(2));

				// TODO: Agregar la lectura del resultado de la consulta BD
				list.add(pst);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	public ArrayList<serigrafiado> filtroxInsumo(int id) {
		ArrayList<serigrafiado> list = null;

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = new ConexionAccess().getConexion();

			// Definir la sentencia SQL
			String sql = "SELECT * FROM tb_serigrafiado where id_insumo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			list = new ArrayList<serigrafiado>();
			while (rs.next()) {
				serigrafiado pst = new serigrafiado(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6),rs.getInt(7), rs.getString(8));

				// TODO: Agregar la lectura del resultado de la consulta BD
				list.add(pst);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
}
