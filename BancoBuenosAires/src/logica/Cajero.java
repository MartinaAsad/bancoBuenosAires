package logica;

public class Cajero {
	private int nroSucursal;
	private int nroCajero;
	private double montoDisponible;
	
	Cajero(){
		
	}

	public Cajero(int nroSucursal, int nroCajero, double montoDisponible) {
		this.nroSucursal = nroSucursal;
		this.nroCajero = nroCajero;
		this.montoDisponible = montoDisponible;
	}

	public int getNroSucursal() {
		return nroSucursal;
	}

	public void setNroSucursal(int nroSucursal) {
		this.nroSucursal = nroSucursal;
	}

	public int getNroCajero() {
		return nroCajero;
	}

	public void setNroCajero(int nroCajero) {
		this.nroCajero = nroCajero;
	}

	public double getMontoDisponible() {
		return montoDisponible;
	}

	public void setMontoDisponible(double montoDisponible) {
		this.montoDisponible = montoDisponible;
	}

	@Override
	public String toString() {
		return "Cajero [numero de sucursal=" + nroSucursal + ", numero de cajero =" + nroCajero + ", monto disponible="
				+ montoDisponible + "]";
	}
	
	
	
	
	

}
