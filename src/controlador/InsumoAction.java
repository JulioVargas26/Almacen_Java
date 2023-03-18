package controlador;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.insumo;
import util.ConexionMySql;

public class InsumoAction {
	
	// Definir los m�todos que interactuar�n con la BD:
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
			String sql = "SELECT * FROM tb_insumo";
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


}


















