package controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.insumo;
import util.ConexionMySql;

public class InsumoAction {
	
	// Definir los métodos que interactuarán con la BD:
		// insertar, eliminar, listar, actualizar, buscarXId
		
	public int ingresarInsumo(insumo i){
		int ingresar = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = new ConexionMySql().getConexion();
			
			cn.setAutoCommit(false);
			
			String sql = "insert into tb_insumo values(null,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, i.getDescripcion());
			
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
	
				
		/**
		public int eliminar(int id){
			int salida = -1;
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				String sql = "DELETE FROM tb_requisitos WHERE idrequisitos = ?";
				
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
		
		public Requisitos obtener(int id){
			Requisitos obj = null;
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				String sql = "SELECT * FROM tb_requisitos WHERE idrequisitos = ?";
				conn = MySqlDBConexion.getConexion();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				rs = pstm.executeQuery();
				while (rs.next()) {
					obj = new Requisitos();					
					obj.setIdrequisitos(rs.getInt("idrequisitos"));
					obj.setEmpresa(rs.getString("empresa"));
					obj.setRuc(rs.getString("ruc"));
					obj.setRazonsocial(rs.getString("razonsocial"));
					obj.setIdadministrado(rs.getString("idadministrado"));
					
					
				
				
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
		
		public int actualizar(Requisitos obj){
			int salida = 0;
			
			// 1. Declarar variables
			Connection conn = null;
			PreparedStatement pstm = null;
			
			// 2. Control de excepciones
			try {
				// 3. Definir la sentencia SQL
				String sql = "UPDATE tb_requisitos SET "
						+ " empresa = ?, ruc  = ?, razonsocial= ?,"	
						+ " solicitud = ?, copiadni  = ?, recibopago = ?,idadministrado = ?"	
				        + " WHERE idrequisitos = ?";
				         	
				// 4. Obtener la conexion
				conn = MySqlDBConexion.getConexion();
				
				// 5. Obtener un PreparedStatement de la conexión
				pstm = conn.prepareStatement(sql);
				
				 pstm.setString(1, obj.getEmpresa());
				 pstm.setString(2, obj.getRuc());
				 pstm.setString(3, obj.getRazonsocial());
				 pstm.setBinaryStream(4, obj.getSolicitud());
				 pstm.setBinaryStream(5, obj.getCopiadni());
				 pstm.setBinaryStream(6, obj.getRecibopago());
				 pstm.setString(7, obj.getIdadministrado());
				 pstm.setInt(8, obj.getIdrequisitos());
				
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
		
		public Administrado buscar(int idadministrado) {	
			Administrado obj = null;
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				
				String sql = "SELECT * FROM tb_administrado WHERE idadministrado = " + "'" + idadministrado + "'";
				
				conn = MySqlDBConexion.getConexion();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				
				if (rs.next()) {
					obj = new Administrado();
					obj.setIdadministrado(rs.getInt("idadministrado"));
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstm != null)
						pstm.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return obj;
		}
		public boolean existClientee(int idadministrado) {
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				
				String sql = "SELECT * FROM tb_administrado WHERE idadministrado = " + idadministrado;
				conn = MySqlDBConexion.getConexion();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				
				if (rs.next()) {
					return true;
				}
				
			} catch (Exception e) {

			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstm != null)
						pstm.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return false;
		}	

		public boolean existCliente(int idrequisitos) {
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			try {
				
				String sql = "SELECT * FROM tb_requisitos WHERE idrequisitos = " + "'" + idrequisitos + "'";
				conn = MySqlDBConexion.getConexion();
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				
				if (rs.next()) {
					return true;
				}
				
			} catch (Exception e) {

			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstm != null)
						pstm.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return false;
		}	
		
		


public Image getImagen(String idrequisitos) {

	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	Image img = null;
	Blob solicitud= null;
	
	try {
		
		 String sql = "select solicitud from tb_requisitos where idrequisitos = "+idrequisitos;
				
		conn = MySqlDBConexion.getConexion();
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery(sql);

		while (rs.next()) {
			solicitud= rs.getBlob("solicitud");
			try {
				img = ImageIO.read(solicitud.getBinaryStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return img;	
}








public Image getImagen2(String idrequisitos) {

	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	Image imgg = null;
	Blob copiadni= null;
	
	try {
		
		 String sql = "select copiadni from tb_requisitos where idrequisitos = "+idrequisitos;
				
		conn = MySqlDBConexion.getConexion();
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery(sql);

		while (rs.next()) {
			copiadni = rs.getBlob("copiadni");
			try {
				imgg = ImageIO.read(copiadni.getBinaryStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return imgg;	
}



public Image getImagen3(String idrequisitos) {

	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	Image imggg = null;
	Blob recibopago= null;
	
	try {
		
		 String sql = "select recibopago from tb_requisitos where idrequisitos = "+idrequisitos;
				
		conn = MySqlDBConexion.getConexion();
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery(sql);

		while (rs.next()) {
			recibopago = rs.getBlob("recibopago");
			try {
				imggg = ImageIO.read(recibopago.getBinaryStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return imggg;	
}




*/


}


















