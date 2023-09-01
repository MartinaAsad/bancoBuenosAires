package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.Conexion;

public class Empleado extends Usuario implements metodosEmpleado{
	//tipo de usuario C es cliente y E empleado
	
	Conexion con =  new Conexion();
	Connection conexion = con.conectar();
	
	public Empleado(){
		super();
	}
	
	public Empleado(String nombres, String apellido, int dni, int nroCuenta, String nombreUsuario, String contrasena) {
		super(nombres, apellido, dni, nroCuenta, nombreUsuario, contrasena);
	}

	@Override
	public boolean ingresarDinero(Cajero nro, double monto) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean altaUsuario() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean bajaUsuario() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean altaCajero() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean bajaCajero(Cajero nro) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean iniciarSesion(String usuario, char[] contra) {
		String contras=String.valueOf(contra);
		boolean validarContrasena = false;
		//char tipoU='C';
		//String tipoUsuario=String.valueOf(tipoU);
        do {

            String sql = "SELECT * FROM `empleado` WHERE nombreUsuario = ? AND contrasena = ?";//cliente
       
            
            PreparedStatement stmt = null;
            ResultSet resultSet = null;

            try {
                stmt = conexion.prepareStatement(sql);
                stmt.setString(1, usuario);
                stmt.setString(2, contras);
                //stmt.setString(3, tipoUsuario);
                resultSet = stmt.executeQuery();
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "listo admin");
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
	public String toString() {
		return "Empleado [Nombres=" + getNombres() + ", Apellido=" + getApellido() + ", Dni=" + getDni()
		+ ", NroCuenta=" + getNroCuenta() + ", NombreUsuario=" + getNombreUsuario()
		+ ", Contrasena=" + getContrasena() + "]";
	}

	@Override
	public boolean modificarCajero(Cajero nro) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
