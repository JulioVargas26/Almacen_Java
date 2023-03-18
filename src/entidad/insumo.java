package entidad;

public class insumo {

	private int cod_insumo;
	private String Descripcion;
	public insumo(int cod_insumo, String descripcion) {
		super();
		this.cod_insumo = cod_insumo;
		Descripcion = descripcion;
	}
	public int getCod_insumo() {
		return cod_insumo;
	}
	public void setCod_insumo(int cod_insumo) {
		this.cod_insumo = cod_insumo;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}
