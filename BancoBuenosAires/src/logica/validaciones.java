package logica;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public abstract class validaciones {
	
	public void soloNumeros(JTextField jtx, KeyEvent e) {
		char c=e.getKeyChar();
		if(c<'0' || c>'9')e.consume();
	}

}
