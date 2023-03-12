package entidad;

public class serigrafiado {
	
	public int id_serigrafiado,insumo,cantSalida,cantIngreso,merma;
	public String guiaSalida,guiaIngreso,fecha;

	public serigrafiado(int id_serigrafiado, int insumo, int cantSalida, int cantIngreso, int merma, String guiaSalida,
			String guiaIngreso, String fecha) {
		this.id_serigrafiado = id_serigrafiado;
		this.insumo = insumo;
		this.cantSalida = cantSalida;
		this.cantIngreso = cantIngreso;
		this.merma = merma;
		this.guiaSalida = guiaSalida;
		this.guiaIngreso = guiaIngreso;
		this.fecha = fecha;
	}

	public serigrafiado() {
		super();
		// TODO Auto-generated constructor stub
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
