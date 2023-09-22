package logica;

public interface metodosEmpleado {
	public boolean ingresarDinero(Cajero nro, double monto);
	
	public boolean altaUsuario();
	
	public boolean bajaUsuario();
	
	public boolean altaCajero();
	
	public boolean bajaCajero(Cajero nro);
	
	public boolean modificarCajero(Cajero nro);
	
	public boolean iniciarSesion(String usuario, char[] contra);

}
