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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class modificarCajero extends JFrame implements metodosCajero, validaciones {

	private JPanel contentPane;
	private JTextField nroSucursal;
	private JTextField nroCajero;
	private JTextField montoNuevo;
	/*en modificar solamente se puede agregar dinero al cajero*/
	
	Conexion con =  new Conexion();
	Connection conexion = con.conectar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarCajero frame = new modificarCajero();
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
	public modificarCajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textoSucursal = new JLabel("Coloque la sucursal del cajero:");
		textoSucursal.setBounds(33, 35, 184, 24);
		contentPane.add(textoSucursal);
		
		JLabel textoNumero = new JLabel("Coloque el numero del cajero:");
		textoNumero.setBounds(33, 77, 184, 24);
		contentPane.add(textoNumero);
		
		JLabel textoMonto = new JLabel("Coloque el nuevo monto del cajero:");
		textoMonto.setBounds(33, 122, 223, 24);
		contentPane.add(textoMonto);
		
		nroSucursal = new JTextField();
		nroSucursal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
			}
		});
		nroSucursal.setBounds(280, 37, 86, 20);
		contentPane.add(nroSucursal);
		nroSucursal.setColumns(10);
		
		nroCajero = new JTextField();
		nroCajero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
			}
		});
		nroCajero.setColumns(10);
		nroCajero.setBounds(280, 79, 86, 20);
		contentPane.add(nroCajero);
		
		montoNuevo = new JTextField();
		montoNuevo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
			}
		});
		montoNuevo.setColumns(10);
		montoNuevo.setBounds(280, 124, 86, 20);
		contentPane.add(montoNuevo);
		
		JButton modificarCajero = new JButton("Modificar");
		modificarCajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verSiExiste();
				agregar(nroSucursal, nroCajero, montoNuevo);
			}
		});
		modificarCajero.setBounds(267, 188, 99, 23);
		contentPane.add(modificarCajero);
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
	public boolean verSiExiste() {
		String infoCampo=nroCajero.getText();
		String infoCampo2=nroSucursal.getText();
		
		if(!verSiEstaVacio(infoCampo, infoCampo2)) {//si no hay campos vacios, hacer la verificacion
		int casteoCampo=Integer.parseInt(infoCampo);
		int casteoCampo2=Integer.parseInt(infoCampo2);
		
		String sql = "SELECT `nroCajero`, `nroSucursal`, `montoDisponible`, `id` FROM `cajero` WHERE nroCajero= ? and nroSucursal= ?";


            try {
            	PreparedStatement stmt = null;
            	ResultSet resultSet = null;
            	
                stmt = conexion.prepareStatement(sql);
                stmt.setLong(1, casteoCampo);
                stmt.setLong(2, casteoCampo2);
                
                resultSet=stmt.executeQuery();
                
                if(resultSet.next()) {
                	//JOptionPane.showMessageDialog(null, "el cajero existe");
                	//agregar(nroSucursal, nroCajero, montoNuevo);
                }else {
                	JOptionPane.showMessageDialog(null, "el cajero no existe");
                	
                }
               
                
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
           }           
		}
		
		return false;
	}

	@Override
	public boolean verSiEstaVacio(String jtx, String jtx2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void verificarYAgregar(JTextField campo, JTextField campo2, JTextField campo3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregar(JTextField campo, JTextField campo2, JTextField campo3) {
		String infoCampo=campo.getText();//aca obtengo el texto ingresado
		String infoCampo2=campo2.getText();
		String infoCampo3=campo3.getText();
		
		int casteoCampo=Integer.parseInt(infoCampo);
		int casteoCampo2=Integer.parseInt(infoCampo2);
		int casteoCampo3=Integer.parseInt(infoCampo3);
		
		String sql = "UPDATE cajero SET montoDisponible = '" + casteoCampo3 + "' WHERE nroCajero = " + casteoCampo2 + " AND nroSucursal = '" + casteoCampo + "'";

            try {
            	PreparedStatement stmt = null;
            	
            	ResultSet resultSet = null;
            	int cantFilas=0;
                stmt = conexion.prepareStatement(sql);
               
                cantFilas=stmt.executeUpdate();
                if(cantFilas>0) {
                	JOptionPane.showMessageDialog(null, "el monto ha sido corregido");
                }else {
                	JOptionPane.showMessageDialog(null, "el monto no ha sido corregido");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
           }           
		}
		
	

	@Override
	public void eliminar(JTextField campo, JTextField campo2) {
		// TODO Auto-generated method stub
		
	}

}
