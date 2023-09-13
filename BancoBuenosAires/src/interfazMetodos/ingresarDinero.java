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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;

public class ingresarDinero extends JFrame implements metodosUsuario, validaciones {

	private JPanel contentPane;
	private JTextField montoAIngresar;
	
	Conexion con =  new Conexion();
	Connection conexion = con.conectar();
	double montoAnterior=0;
	double montoNuevo=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ingresarDinero frame = new ingresarDinero();
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
	public ingresarDinero() {
		setTitle("Banco Buenos Aires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 238);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 172, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel monto = new JLabel("Ingrese el monto: ");
		monto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		monto.setBounds(10, 34, 164, 19);
		contentPane.add(monto);
		
		montoAIngresar = new JTextField();
		montoAIngresar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
			}
		});
		montoAIngresar.setBounds(200, 33, 86, 20);
		contentPane.add(montoAIngresar);
		montoAIngresar.setColumns(10);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verSiEstaVacio();
				ingresarDinero();
			}
		});
		confirmar.setBounds(200, 176, 123, 23);
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
	public boolean iniciarSesion(String usuario, char[] contra) {
		// TODO Auto-generated method stub
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
		String texto=montoAIngresar.getText();
		int numero= Integer.parseInt(texto);//casteo asi lo puedo almacenar
		
		String obtengoTotalAnterior="SELECT saldo FROM usuario WHERE nombreUsuario=? AND contrasena=?";
		String ingresar="UPDATE usuario SET saldo = ? WHERE nombreUsuario=? AND contrasena=?";
		
		try {
			PreparedStatement stmt = null;
			PreparedStatement stmt2 = null;
        	int cantFilasAfectadas = 0;
        	ResultSet resultSet = null;
        	ResultSet resultSet2 = null;
            stmt = conexion.prepareStatement(obtengoTotalAnterior);
            stmt2=conexion.prepareStatement(ingresar);
            
            if(resultSet.next()) {
            	montoAnterior=resultSet.getDouble("saldo");
            	System.out.println(montoAnterior);
            }
            
            if(resultSet2.next()) {
            	montoNuevo=montoAnterior+resultSet2.getDouble("saldo");
            	System.out.println(montoNuevo);
            }
            
			
		}catch(Exception e2) {
			JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
		}
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
	public boolean verSiEstaVacio() {
		String texto=montoAIngresar.getText();
		if(texto.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "por favor ingrese un numero");
		}
		return false;
	}

	@Override
	public int existeUsuario() {
		// TODO Auto-generated method stub
		return 0;
	}
}
