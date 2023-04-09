package entidad;

public class serigrafiado {
	
	public int id_serigrafiado;
	public int cantSalida;
	public String guiaSalida;
	public int cantIngreso;
	public String guiaIngreso;
	public int merma;
	public String fecha;
	public int insumo;

	public serigrafiado(int id_serigrafiado, int cantSalida, String guiaSalida, int cantIngreso, String guiaIngreso,
			int merma, String fecha, int insumo) {
		super();
		this.id_serigrafiado = id_serigrafiado;
		this.cantSalida = cantSalida;
		this.guiaSalida = guiaSalida;
		this.cantIngreso = cantIngreso;
		this.guiaIngreso = guiaIngreso;
		this.merma = merma;
		this.fecha = fecha;
		this.insumo = insumo;
	}

	public int getId_serigrafiado() {
		return id_serigrafiado;
	}

	public void setId_serigrafiado(int id_serigrafiado) {
		this.id_serigrafiado = id_serigrafiado;
	}

	public int getInsumo() {
		return insumo;
	}

	public void setInsumo(int insumo) {
		this.insumo = insumo;
	}

	public int getCantSalida() {
		return cantSalida;
	}

	public void setCantSalida(int cantSalida) {
		this.cantSalida = cantSalida;
	}

	public int getCantIngreso() {
		return cantIngreso;
	}

	public void setCantIngreso(int cantIngreso) {
		this.cantIngreso = cantIngreso;
	}

	public int getMerma() {
		return merma;
	}

	public void setMerma(int merma) {
		this.merma = merma;
	}

	public String getGuiaSalida() {
		return guiaSalida;
	}

	public void setGuiaSalida(String guiaSalida) {
		this.guiaSalida = guiaSalida;
	}

	public String getGuiaIngreso() {
		return guiaIngreso;
	}

	public void setGuiaIngreso(String guiaIngreso) {
		this.guiaIngreso = guiaIngreso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	

}
