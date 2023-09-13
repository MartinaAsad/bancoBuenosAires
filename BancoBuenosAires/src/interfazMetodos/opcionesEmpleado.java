package interfazMetodos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class opcionesEmpleado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opcionesEmpleado frame = new opcionesEmpleado();
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
	public opcionesEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 397);
		setTitle("Seleccione una opcion");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonAltaUsuario = new JButton("Alta usuario");
		botonAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		botonAltaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonAltaUsuario.setBounds(35, 51, 138, 39);
		contentPane.add(botonAltaUsuario);
		
		JButton botonBajaUsuario = new JButton("Baja usuario");
		botonBajaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonBajaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonBajaUsuario.setBounds(221, 51, 138, 39);
		contentPane.add(botonBajaUsuario);
		
		JButton botonAltaCajero = new JButton("Alta cajero");
		botonAltaCajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaCajero ac=new altaCajero();
				ac.setVisible(true);
			}
		});
		botonAltaCajero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		botonAltaCajero.setBounds(35, 168, 138, 39);
		contentPane.add(botonAltaCajero);
		
		JButton btnBajaCajero = new JButton("Baja cajero");
		btnBajaCajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bajaCajero bc=new bajaCajero();
				bc.setVisible(true);
			}
		});
		btnBajaCajero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBajaCajero.setBounds(221, 168, 138, 39);
		contentPane.add(btnBajaCajero);
		
		JButton btnModificarCajero = new JButton("Modificar cajero");
		btnModificarCajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarCajero mc=new modificarCajero();
				mc.setVisible(true);
			}
		});
		btnModificarCajero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModificarCajero.setBounds(407, 168, 173, 39);
		contentPane.add(btnModificarCajero);
	}
}
