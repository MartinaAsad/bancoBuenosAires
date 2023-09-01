package interfazMetodos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class altaCajero extends JFrame{

	private JPanel contentPane;
	private JTextField textoNroCajero;
	private JTextField textoNroSucursal;
	private JTextField textoMonto;

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
	
	//funcion que chequea que no se hayan ingresado valores repetidos
	
	

	/**
	 * Create the frame.
	 */
	public altaCajero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		textoNroCajero.setBounds(178, 31, 86, 20);
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
		textoNroSucursal.setBounds(178, 85, 86, 20);
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
		botonConfirmar.setBounds(335, 238, 89, 23);
		contentPane.add(botonConfirmar);
	}
}
