package interfaces.ejemplo1;

import javax.swing.JOptionPane;

public class JOptionPane4 {

	public static void main(String[] args) {
		
		String nombre = JOptionPane.showInputDialog(null, "Dime tu nombre", "Datos personales",
				JOptionPane.QUESTION_MESSAGE);
		if (nombre != null) {
			System.out.println("Tu nombre es " + nombre);
		} else {
			System.out.println("Has pulsado cancelar, verguenza deberia darte");
		}

	}

}
