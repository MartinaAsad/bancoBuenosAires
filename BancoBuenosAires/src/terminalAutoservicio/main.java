package terminalAutoservicio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfazMetodos.opcionesCliente;
import interfazMetodos.opcionesEmpleado;
import interfazMetodos.retirarDinero;
import logica.Empleado;
import logica.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	Usuario us=new Usuario();
	Empleado empleado=new Empleado();
	String nombreUsuario=us.getNombreUsuario();
	String contrasena=us.getContrasena();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 415);
		this.setLocationRelativeTo(null);//aparece en el medio
		setTitle("Banco Buenos Aires");
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 244, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelUsuario = new JLabel("Usuario:");
		LabelUsuario.setFont(new Font("Arial", Font.PLAIN, 35));
		LabelUsuario.setBounds(39, 50, 167, 30);
		contentPane.add(LabelUsuario);
		
		JLabel LabelContrasena = new JLabel("Contrasena:");
		LabelContrasena.setFont(new Font("Arial", Font.PLAIN, 35));
		LabelContrasena.setBounds(39, 189, 279, 30);
		contentPane.add(LabelContrasena);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(39, 110, 260, 37);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Iniciar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario=textFieldUsuario.getText();
				char[] contra=passwordField.getPassword();
				String contra2=String.valueOf(contra);
				//us.iniciarSesion(usuario, contra);
				if(us.iniciarSesion(usuario, contra)) {
					us.setNombreUsuario(usuario);
					us.setContrasena(contra2);
					/*System.out.println(us.getNombreUsuario());
					System.out.println(us.getContrasena());
					JOptionPane.showMessageDialog(null, "gf");*/
				}else {
					//empleado.iniciarSesion(usuario, contra);
					//JOptionPane.showMessageDialog(null, "gf2");
					retirarDinero rd=new retirarDinero();
					rd.traerDatosSesion(usuario, contra);
					rd.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 17));
		btnNewButton.setBounds(447, 342, 136, 34);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(39, 246, 260, 37);
		contentPane.add(passwordField);
		
		/*String usuario=textFieldUsuario.getText();
		char[] contra=passwordField.getPassword();
		String contra2=String.valueOf(contra);*/
	}
}