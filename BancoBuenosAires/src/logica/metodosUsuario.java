package logica;

public interface metodosUsuario {
	
	public boolean iniciarSesion(String usuario, char[] contra);
	
	public boolean retirarDinero();
	
	public boolean ingresarDinero();
	
	public void consultarSaldo();
	
	public void realizarTransferencias();
	
	public void cambioDeClave();
	
	public void verHistorial();

	public void traerDatosSesion(String usuario, char [] contra);
	
}
