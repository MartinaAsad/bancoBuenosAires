package interfazMetodos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conexion;
import logica.Cajero;
import logica.metodosEmpleado;
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
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class altaUsuario extends JFrame implements metodosEmpleado, validaciones{

	private JPanel contentPane;
	private JTextField nc;
	private JTextField apellido;
	private JTextField dni;
	private JTextField nUsuario;
	private JTextField clave;
	private JTextField textField;

	Conexion con =  new Conexion();
	Connection conexion = con.conectar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaUsuario frame = new altaUsuario();
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
	public altaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 382);
		setTitle("Alta usuario");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreC = new JLabel("Nombre completo:");
		nombreC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nombreC.setBounds(10, 26, 117, 14);
		contentPane.add(nombreC);
		
		JLabel ape = new JLabel("Apellido:");
		ape.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ape.setBounds(10, 65, 117, 14);
		contentPane.add(ape);
		
		JLabel documento = new JLabel("DNI:");
		documento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		documento.setBounds(10, 109, 117, 14);
		contentPane.add(documento);
		
		JLabel nombreU = new JLabel("Nombre de usuario:");
		nombreU.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nombreU.setBounds(10, 148, 117, 14);
		contentPane.add(nombreU);
		
		JLabel contra = new JLabel("Contrase\u00F1a:");
		contra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contra.setBounds(10, 193, 117, 14);
		contentPane.add(contra);
		
		JLabel monto = new JLabel("Saldo:");
		monto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		monto.setBounds(10, 245, 117, 14);
		contentPane.add(monto);
		
		nc = new JTextField();
		nc.setBounds(286, 24, 169, 20);
		contentPane.add(nc);
		nc.setColumns(10);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(286, 63, 169, 20);
		contentPane.add(apellido);
		
		dni = new JTextField();
		dni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
			}
		});
		dni.setColumns(10);
		dni.setBounds(286, 107, 169, 20);
		contentPane.add(dni);
		
		nUsuario = new JTextField();
		nUsuario.setColumns(10);
		nUsuario.setBounds(286, 146, 169, 20);
		contentPane.add(nUsuario);
		
		clave = new JTextField();
		clave.setColumns(10);
		clave.setBounds(286, 191, 169, 20);
		contentPane.add(clave);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(c<'0' || c>'9')e.consume();
			}
		});
		textField.setColumns(10);
		textField.setBounds(286, 243, 169, 20);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Dar de alta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verSiEstaVacio();
				if(existeUsuario()==0) {//si el usuario o dni no existe, lo va a agregar
					altaUsuario();
				}else {
					JOptionPane.showMessageDialog(null, "el usuario o dni ya existe");
				}
			}
		});
		btnNewButton.setBounds(390, 309, 108, 23);
		contentPane.add(btnNewButton);
	}

	@Override
	public boolean verSiEstaVacio(String jtx, String jtx2, String jtx3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verSiExiste() {
		return false;
	}

	@Override
	public boolean verSiEstaVacio(String jtx, String jtx2) {
		return false;
	}

	@Override
	public boolean verSiEstaVacio() {
		// TODO Auto-generated method stub
		String texto1=nc.getText();//nombre completo
		String texto2=apellido.getText();//apellido
		String texto3=dni.getText();//dni
		String texto4=nUsuario.getText();//nombre de usuario
		String texto5=clave.getText();//contraseña
		
		if(texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty() 
				|| texto5.isEmpty()){
			JOptionPane.showMessageDialog(null,"complete los campos vacios");
		}
		return false;
	}

	@Override
	public boolean ingresarDinero(Cajero nro, double monto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaUsuario() {
		// TODO Auto-generated method stub
		String nombre=nc.getText();//aca obtengo el texto ingresado
		String ape=apellido.getText();
		String documento=dni.getText();
		String nombreU=nUsuario.getText();
		int casteoDni=Integer.parseInt(documento);
		String contra=clave.getText();
		String monto=textField.getText();
		double casteoSaldo=Double.parseDouble(monto);
		
		if(!verSiEstaVacio()) {//si no hay campos vacios, hacer la verificacion
		
		String sql = "INSERT INTO `usuario`(`nombreCompleto`, `apellido`, `dni`, `nombreUsuario`, `contrasena`, `saldo`) "
		        + "VALUES (?, ?, ?, ?, ?, ?)";



            try {
            	PreparedStatement stmt = null;
            	int cantFilasAfectadas = 0;
            	ResultSet resultSet = null;
                stmt = conexion.prepareStatement(sql);
                stmt.setString(1, nombre);
                stmt.setString(2, ape);
                stmt.setLong(3, casteoDni);
                stmt.setString(4, nombreU);
                stmt.setString(5, contra);
                stmt.setDouble(6, casteoSaldo);
               
                cantFilasAfectadas = stmt.executeUpdate();
                if (cantFilasAfectadas > 0) { // Check if any rows were affected
                    JOptionPane.showMessageDialog(null, "El usuario se agrego correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
           }           
		}
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
	public boolean modificarCajero(Cajero nro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean iniciarSesion(String usuario, char[] contra) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int existeUsuario() {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		String documento=dni.getText();
		String nombreU=nUsuario.getText();
		int casteoDni=Integer.parseInt(documento);
		String sql = "SELECT count(dni) FROM `usuario` WHERE dni = ? OR nombreUsuario = ?";//aca cuanta la cantidad 
																				//de veces que aparece
																			//el usuario en la bbdd

        try {
            stmt = conexion.prepareStatement(sql);
            stmt.setLong(1, casteoDni);
            stmt.setString(2, nombreU);
            //stmt.setString(3, tipoUsuario);
            resultSet = stmt.executeQuery();
            if(resultSet.next()) {//en caso de existir
            	return resultSet.getInt(1);
            }
            
            return 1;
		
	
	}catch(Exception e2) {
		JOptionPane.showMessageDialog(null, "Hubo un error: " + e2.getMessage());
		return 1;
	}
	}

}
