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

		//Connection cn = new ConexionAccess().getConexion();
		Connection cn = new ConexionMySql().getConexion();
		
		PreparedStatement pstm = null;
		// 1. Control de excepciones
		try {
			// 2. Definir la sentencia SQL
			String sql = "INSERT INTO tb_serigrafiado VALUES (null, ?, ?, ?, ?, ?, ?, ?)";

			// 3. Obtener un PreparedStatement de la conexi�n
			pstm = cn.prepareStatement(sql);

			// 4. Agregar parametros

			pstm.setInt(1, s.getInsumo());
			pstm.setInt(2, s.getCantSalida());
			pstm.setString(3, s.getGuiaSalida());
			pstm.setInt(4, s.getCantIngreso());
			pstm.setString(5, s.getGuiaIngreso());
			pstm.setInt(6, s.getMerma());
			pstm.setString(7, s.getFecha());

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

		//Connection cn = new ConexionAccess().getConexion();
		Connection cn = new ConexionMySql().getConexion();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {

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

	public ArrayList<serigrafiado> filtroxInsumo(int id) {
		ArrayList<serigrafiado> list = null;

		//Connection cn = new ConexionAccess().getConexion();
		Connection cn = new ConexionMySql().getConexion();

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
				serigrafiado pst = new serigrafiado(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getString(8));
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
