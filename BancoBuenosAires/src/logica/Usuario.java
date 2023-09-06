package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import conexion.Conexion;

public class Usuario implements metodosUsuario{
	private String nombres;
	private String apellido;
	private int dni;
	private int nroCuenta;
	private String nombreUsuario;
	private String contrasena;
	
	Conexion con =  new Conexion();
	
	Connection conexion = con.conectar();
	
	public Usuario(){
		
	}

	public Usuario(String nombres, String apellido, int dni, int nroCuenta, String nombreUsuario, String contrasena) {
		this.nombres = nombres;
		this.apellido = apellido;
		this.dni = dni;
		this.nroCuenta = nroCuenta;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	@Override
	public boolean iniciarSesion(String usuario, char[] contra) {
		// TODO Auto-generated method stub
		String contras=String.valueOf(contra);
		boolean validarContrasena = false;
		//char tipoU='C';
		//String tipoUsuario=String.valueOf(tipoU);
        do {

            String sql = "SELECT * FROM `usuario` WHERE nombreUsuario = ? AND contrasena = ?";//cliente
       
            
            PreparedStatement stmt = null;
            ResultSet resultSet = null;

            try {
                stmt = conexion.prepareStatement(sql);
                stmt.setString(1, usuario);
                stmt.setString(2, contras);
                //stmt.setString(3, tipoUsuario);
                resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "listo");
                    validarContrasena = true;
                    resultSet.close();
                    stmt.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
                    break;
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
           }           
        } while (!validarContrasena);
		return false;
	}

	@Override
	public boolean retirarDinero() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ingresarDinero() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void consultarSaldo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realizarTransferencias() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambioDeClave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verHistorial() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Usuario [nombres=" + nombres + ", apellido=" + apellido + ", dni=" + dni + ", nroCuenta=" + nroCuenta
				+ ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + "]";
	}

	
	
	
	
	
	
	

}
