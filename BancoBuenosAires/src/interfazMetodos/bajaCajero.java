package interfazMetodos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conexion;
import logica.metodosCajero;
import logica.validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bajaCajero extends JFrame implements validaciones, metodosCajero {

	private JPanel contentPane;
	private JTextField campoNroC;
	private JTextField campoNroS;
	
	Conexion con =  new Conexion();
	Connection conexion = con.conectar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bajaCajero frame = new bajaCajero();
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
	public bajaCajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nroCajero = new JLabel("Ingrese numero de cajero:");
		nroCajero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nroCajero.setBounds(34, 43, 179, 22);
		contentPane.add(nroCajero);
		
		JLabel nroSucursal = new JLabel("Ingrese numero de sucursal:");
		nroSucursal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nroSucursal.setBounds(34, 98, 179, 22);
		contentPane.add(nroSucursal);
		
		campoNroC = new JTextField();
		campoNroC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {//aca se valida que solo se permiten numeros
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
			}
		});
		campoNroC.setBounds(235, 45, 86, 20);
		contentPane.add(campoNroC);
		campoNroC.setColumns(10);
		
		campoNroS = new JTextField();
		campoNroS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();	//aca se valida que solo se permiten numeros
			}
		});
		campoNroS.setColumns(10);
		campoNroS.setBounds(235, 100, 86, 20);
		contentPane.add(campoNroS);
		
		JButton botonConfirmar = new JButton("Dar de baja");
		botonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar(campoNroS, campoNroC);
				
			}
		});
		botonConfirmar.setBounds(222, 180, 119, 23);
		contentPane.add(botonConfirmar);
	}

	@Override
	public void verificarYAgregar(JTextField campo, JTextField campo2, JTextField campo3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregar(JTextField campo, JTextField campo2, JTextField campo3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(JTextField campo, JTextField campo2) {
		// TODO Auto-generated method stub
		String infoNroC= campo.getText();
		String infoNroS=campo2.getText();
		if(!verSiEstaVacio(infoNroC, infoNroS)) {//si no hay campos vacios, hacer la verificacion
			int casteoCampo=Integer.parseInt(infoNroC);
			int casteoCampo2=Integer.parseInt(infoNroS);
			
			String sql="DELETE from `cajero` WHERE nroCajero= ? and nroSucursal= ?";
			try {
				   PreparedStatement stmt = conexion.prepareStatement(sql);   
				   stmt.setLong(1, casteoCampo);
				   stmt.setLong(2, casteoCampo2);
				   stmt.executeUpdate();
				   stmt.close();
				   JOptionPane.showMessageDialog(null, "cajero correctamente eliminado");
				   //return true;
				  } catch (Exception e2) {
				   System.out.println("Hubo un error " + e2.getMessage());
				   //return false;
				  }
		
		}
		
	}

	@Override
	public boolean verSiEstaVacio(String jtx, String jtx2, String jtx3) {
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
		boolean verificar=false;
		if(jtx.equals("") || jtx2.equals("")) {//verifico si los campos estan vacios
			JOptionPane.showMessageDialog(null, "Hay campos vacios");
			verificar=true;
		}
		return verificar;
	}
}
