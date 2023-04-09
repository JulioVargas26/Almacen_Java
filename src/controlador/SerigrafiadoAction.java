package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.serigrafiado;
import util.ConexionAccess;
import util.ConexionMySql;

public class SerigrafiadoAction {

	// Definir los m�todos que interactuar�n con la BD:
	// insertar, eliminar, listar, actualizar, filtraXId, exportarData

	public int IngresarSerigrafiado(serigrafiado s) {
		int salida = 0;

		Connection cn = new ConexionAccess().getConexion();
		//Connection cn = new ConexionMySql().getConexion();
		
		PreparedStatement pstm = null;
		// 1. Control de excepciones
		try {
			// 2. Definir la sentencia SQL
			String sql = "INSERT INTO tb_serigrafiado VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

			// 3. Obtener un PreparedStatement de la conexi�n
			pstm = cn.prepareStatement(sql);

			// 4. Agregar parametros

			pstm.setInt(1, s.getCantSalida());
			pstm.setString(2, s.getGuiaSalida());
			pstm.setInt(3, s.getCantIngreso());
			pstm.setString(4, s.getGuiaIngreso());
			pstm.setInt(5, s.getMerma());
			pstm.setString(6, s.getFecha());
			pstm.setInt(7, s.getInsumo());

			// 5. Ejecutar
			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexion y otros objetos
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return salida;

	}

	public ArrayList<serigrafiado> ListarSerigrafiado() {
		ArrayList<serigrafiado> lista = new ArrayList<serigrafiado>();

		Connection cn = new ConexionAccess().getConexion();
		//Connection cn = new ConexionMySql().getConexion();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

			String sql = "SELECT * FROM tb_serigrafiado";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				serigrafiado obj = new serigrafiado(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8));

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

	public ArrayList<serigrafiado> filtroxInsumo(int id) {
		ArrayList<serigrafiado> list = null;

		Connection cn = new ConexionAccess().getConexion();
		//Connection cn = new ConexionMySql().getConexion();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			// Definir la sentencia SQL
			String sql = "SELECT * FROM tb_serigrafiado where tipo_insumo = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			list = new ArrayList<serigrafiado>();
			while (rs.next()) {
				serigrafiado pst = new serigrafiado(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8));

				// Agregar la lectura del resultado de la consulta BD
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
				if (cn != null)
					cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	

}
