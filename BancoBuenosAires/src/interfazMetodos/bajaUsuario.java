package interfazMetodos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conexion;
import logica.Cajero;
import logica.metodosEmpleado;
import logica.validaciones;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class bajaUsuario extends JFrame implements metodosEmpleado, validaciones {

	private JPanel contentPane;
	private JTextField usuarioBaja;
	Conexion con =  new Conexion();
	Connection conexion = con.conectar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bajaUsuario frame = new bajaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bajaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 183);
		setTitle("Baja usuario");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usuarioBaja = new JTextField();
		usuarioBaja.setBounds(318, 51, 86, 20);
		contentPane.add(usuarioBaja);
		usuarioBaja.setColumns(10);
		
		JLabel texto = new JLabel("Ingrese nombre del usuario a dar de baja:");
		texto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		texto.setBounds(22, 53, 266, 18);
		contentPane.add(texto);
		
		JButton darDeBaja = new JButton("Confirmar");
		darDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verSiEstaVacio();
				bajaUsuario();
			}
		});
		darDeBaja.setBounds(292, 121, 112, 23);
		contentPane.add(darDeBaja);
	}

	@Override
	public boolean verSiEstaVacio(String jtx, String jtx2, String jtx3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verSiExiste() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verSiEstaVacio(String jtx, String jtx2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verSiEstaVacio() {
		// TODO Auto-generated method stub
		String texto = usuarioBaja.getText();
		if(texto.isEmpty()) {
			JOptionPane.showMessageDialog(null, "ingrese un usuario");
		}
		return false;
	}

	@Override
	public int existeUsuario() {
		// TODO Auto-generated method stub
		return 0;
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
		String texto = usuarioBaja.getText();
		String sql ="DELETE FROM usuario WHERE nombreUsuario = ?";
		int cantFilas = 0;
		try {
			   PreparedStatement stmt = conexion.prepareStatement(sql);   
			   stmt.setString(1, texto);
			   cantFilas=stmt.executeUpdate();//either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
			   if(cantFilas==1) {
				   JOptionPane.showMessageDialog(null, "usuario correctamente eliminado");
			   }else {
				   JOptionPane.showMessageDialog(null, "el usuario a eliminar no existe en la base de datos");
			   }
			   //JOptionPane.showMessageDialog(null, "usuario correctamente eliminado");
			   //return true;
			  } catch (Exception e2) {
			   System.out.println("Hubo un error " + e2.getMessage());
			   //return false;
			  }
	
		
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
	public boolean modificarCajero(Cajero nro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean iniciarSesion(String usuario, char[] contra) {
		// TODO Auto-generated method stub
		return false;
	}
}

