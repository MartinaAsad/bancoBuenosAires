package interfazMetodos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conexion;
import logica.metodosCajero;
import logica.validaciones;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class altaCajero extends JFrame implements metodosCajero, validaciones{

	private JPanel contentPane;
	private JTextField textoNroCajero;
	private JTextField textoNroSucursal;
	private JTextField textoMonto;

	Conexion con =  new Conexion();
	Connection conexion = con.conectar();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaCajero frame = new altaCajero();
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
	public altaCajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Alta cajero");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textoNroCajero = new JTextField();
		
		textoNroCajero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {//aca se valida que solo se permiten numeros
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();

			}
		});
		
		textoNroCajero.setBackground(new Color(255, 255, 255));
		textoNroCajero.setBounds(178, 37, 86, 20);
		contentPane.add(textoNroCajero);
		textoNroCajero.setColumns(10);
		
		textoNroSucursal = new JTextField();
		textoNroSucursal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {//aca se valida que solo se permiten numeros
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();

			}
		});
		textoNroSucursal.setColumns(10);
		textoNroSucursal.setBackground(Color.WHITE);
		textoNroSucursal.setBounds(178, 88, 86, 20);
		contentPane.add(textoNroSucursal);
		
		textoMonto = new JTextField();
		textoMonto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {//aca se valida que solo se permiten numeros
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();

			}
		});
		textoMonto.setColumns(10);
		textoMonto.setBackground(Color.WHITE);
		textoMonto.setBounds(178, 149, 86, 20);
		contentPane.add(textoMonto);
		
		JLabel lblNewLabel = new JLabel("Numero de cajero:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(24, 34, 119, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumeroDeSucursal = new JLabel("Numero de sucursal:");
		lblNumeroDeSucursal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumeroDeSucursal.setBounds(24, 85, 119, 25);
		contentPane.add(lblNumeroDeSucursal);
		
		JLabel lblMontoDisponible = new JLabel("Monto disponible:");
		lblMontoDisponible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMontoDisponible.setBounds(24, 149, 119, 25);
		contentPane.add(lblMontoDisponible);
		
		JButton botonConfirmar = new JButton("Dar de alta");
		botonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarYAgregar(textoNroCajero, textoNroSucursal, textoMonto);//verifica si el cajero ingresado ya existe en esa sucursal
				
			}
		});
		botonConfirmar.setBounds(299, 238, 125, 23);
		contentPane.add(botonConfirmar);
	}




	@Override
	public void verificarYAgregar(JTextField campo, JTextField campo2, JTextField campo3) {
		// TODO Auto-generated method stub
		String infoCampo=campo.getText();//aca obtengo el texto ingresado
		String infoCampo2=campo2.getText();
		String infoCampo3=campo3.getText();
		
		if(!verSiEstaVacio(infoCampo, infoCampo2, infoCampo3)) {//si no hay campos vacios, hacer la verificacion
		int casteoCampo=Integer.parseInt(infoCampo);
		int casteoCampo2=Integer.parseInt(infoCampo2);
		boolean validarId = false;
        do {

            String sql = "SELECT * FROM `cajero` WHERE nroCajero = ? AND nroSucursal = ?";//cliente
       
            
            PreparedStatement stmt = null;
            ResultSet resultSet = null;

            try {
                stmt = conexion.prepareStatement(sql);
                stmt.setLong(1, casteoCampo);
                stmt.setLong(2, casteoCampo2);
                //stmt.setString(3, tipoUsuario);
                resultSet = stmt.executeQuery();
                if (resultSet.next()) {//en caso de que la consulta me traiga resultado
                    JOptionPane.showMessageDialog(null, "El numero de cajero ya existe en esa sucursal");
                    validarId = true;
                    resultSet.close();
                    stmt.close();
                }else {//en caso de que la consulta no traiga resultados, dar de alta
                	 agregar(campo, campo2, campo3);
                	 //JOptionPane.showMessageDialog(null, "El numero de cajero se agrego correctamente");
                	break;
                	
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
           }           
        } while (!validarId);
		}
		//return false;
	}




	@Override
	public boolean verSiEstaVacio(String jtx, String jtx2, String jtx3) {
		boolean verificar=false;
		if(jtx.equals("") || jtx2.equals("")|| jtx3.equals("")) {//verifico si los campos estan vacios
			JOptionPane.showMessageDialog(null, "Hay campos vacios");
			verificar=true;
		}
		return verificar;
		
	}




	@Override
	public void agregar(JTextField campo, JTextField campo2, JTextField campo3) {
		// TODO Auto-generated method stub
		String infoCampo=campo.getText();//aca obtengo el texto ingresado
		String infoCampo2=campo2.getText();
		String infoCampo3=campo3.getText();
		
		if(!verSiEstaVacio(infoCampo, infoCampo2, infoCampo3)) {//si no hay campos vacios, hacer la verificacion
		int casteoCampo=Integer.parseInt(infoCampo);
		int casteoCampo2=Integer.parseInt(infoCampo2);
		int casteoCampo3=Integer.parseInt(infoCampo3);
		
		String sql = "INSERT INTO `cajero`(`nroCajero`, `nroSucursal`, `montoDisponible`) "
	             + "VALUES (?, ?, ?)";


            try {
            	PreparedStatement stmt = null;
            	int cantFilasAfectadas = 0;
            	ResultSet resultSet = null;
                stmt = conexion.prepareStatement(sql);
                stmt.setLong(1, casteoCampo);
                stmt.setLong(2, casteoCampo2);
                stmt.setLong(3, casteoCampo3);
               
                cantFilasAfectadas = stmt.executeUpdate();
                if (cantFilasAfectadas > 0) { // Check if any rows were affected
                    JOptionPane.showMessageDialog(null, "El cajero se agrego correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el cajero");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
           }           
		}
	}




	@Override
	public void eliminar(JTextField campo, JTextField campo2) {
		// TODO Auto-generated method stub
		
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
		return false;
	}




	@Override
	public int existeUsuario() {
		// TODO Auto-generated method stub
		return 0;
	}




	
}
