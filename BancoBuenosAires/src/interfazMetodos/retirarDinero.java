package interfazMetodos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conexion;
import logica.metodosUsuario;
import logica.validaciones;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class retirarDinero extends JFrame implements validaciones, metodosUsuario{

	private JPanel contentPane;
	private JTextField monto;
	
	Conexion con =  new Conexion();
	Connection conexion = con.conectar();
	double montoAnterior=0;
	double montoNuevo=0;
	private String nombreUsuario;
	private String contrasena;

	public retirarDinero(String nombreUsuario, String contrasena) {
	    this.nombreUsuario = nombreUsuario;
	    this.contrasena = contrasena;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
	    this.nombreUsuario = nombreUsuario;
	}

	public void setContrasena(String contrasena) {
	    this.contrasena = contrasena;
	}




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retirarDinero frame = new retirarDinero();
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
	public retirarDinero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Retirar dinero");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 172, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textoMonto = new JLabel("Ingrese el monto a retirar:");
		textoMonto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textoMonto.setBounds(27, 34, 254, 27);
		contentPane.add(textoMonto);
		
		monto = new JTextField();
		monto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
			}
		});
		monto.setBounds(278, 39, 86, 20);
		contentPane.add(monto);
		monto.setColumns(10);
		
		
		JButton confirmar = new JButton("Retirar dinero");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verSiEstaVacio();
			}
		});
		confirmar.setBounds(291, 227, 133, 23);
		contentPane.add(confirmar);
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
		String texto=monto.getText();
		if(texto.isEmpty()) {
			JOptionPane.showMessageDialog(null, "por favor ingrese un numero");
		}
		return false;
	}

	@Override
	public int existeUsuario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean iniciarSesion(String usuario, char[] contra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retirarDinero() {
		// TODO Auto-generated method stub
		String texto=monto.getText();
		double monto=Double.parseDouble(texto);
		
		String sql="UPDATE usuario SET saldo = ? WHERE nombreUsuario=? AND contrasena=?";//aca se pone el resultaod nuevo
		String obtengoTotalAnterior="SELECT saldo FROM usuario WHERE nombreUsuario=? AND contrasena=?";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(obtengoTotalAnterior);
			PreparedStatement stmt2 = conexion.prepareStatement(sql);
        	int cantFilasAfectadas = 0;
        	ResultSet resultSet = stmt.executeQuery();
        	ResultSet resultSet2 = stmt2.executeQuery();
        	
        	//stmt.setString(1, texto);
        	stmt2.setDouble(1,montoNuevo);
            stmt2.setString(2, nombreUsuario);//chequear esta linea y la siguiente
            stmt2.setString(3, contrasena);
            
            while (resultSet.next()) {
            	montoAnterior=stmt.getResultSet().getDouble("saldo");
            	
            	System.out.println(montoAnterior);
            }
            
            while (resultSet2.next()) {
            	montoNuevo=montoAnterior-stmt2.getResultSet().getDouble("saldo");
            	System.out.println(montoNuevo);
            }
            
			
		}catch(Exception e2) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
		}
		
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
	public void traerDatosSesion(String usuario, char[] contra) {
		// aca traigo el usuario y contraseña para ver a que usuario se le descontara el dinero
		this.nombreUsuario = usuario;
		nombreUsuario=usuario;
		String contra2=String.valueOf(contra);
		this.contrasena = contra2;
		contrasena = contra2;
		System.out.println(nombreUsuario);
		System.out.println(contrasena);
		
	}
}
