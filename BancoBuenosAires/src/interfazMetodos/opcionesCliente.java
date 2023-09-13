package interfazMetodos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.metodosUsuario;
import logica.validaciones;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class opcionesCliente extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opcionesCliente frame = new opcionesCliente();
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
	public opcionesCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 172, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton retiroD = new JButton("Retirar dinero");
		retiroD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		retiroD.setBounds(26, 46, 156, 30);
		contentPane.add(retiroD);
		
		JButton ingresarD = new JButton("Ingresar dinero");
		ingresarD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarDinero id=new ingresarDinero();
				id.setVisible(true);
			}
		});
		ingresarD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ingresarD.setBounds(253, 46, 156, 30);
		contentPane.add(ingresarD);
		
		JButton realizarT = new JButton("Realizar transferencia");
		realizarT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		realizarT.setBounds(26, 113, 200, 30);
		contentPane.add(realizarT);
		
		JButton consultarS = new JButton("Consultar saldo");
		consultarS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		consultarS.setBounds(26, 183, 156, 30);
		contentPane.add(consultarS);
		
		JButton cambioC = new JButton("Cambio de clave");
		cambioC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cambioC.setBounds(253, 183, 156, 30);
		contentPane.add(cambioC);
		
		JButton verH = new JButton("Ver historial");
		verH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		verH.setBounds(253, 113, 156, 30);
		contentPane.add(verH);
		setTitle("Seleccione una opcion");
	}
}
