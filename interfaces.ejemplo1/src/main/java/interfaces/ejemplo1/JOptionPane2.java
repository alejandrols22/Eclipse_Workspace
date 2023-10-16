package interfaces.ejemplo1;

import javax.swing.JOptionPane;

public class JOptionPane2 {

	public static void main(String[] args) {

		String nombre = JOptionPane.showInputDialog(null, "Dime tu nombre", "Datos Personales",
				JOptionPane.QUESTION_MESSAGE);

		if (nombre != null) {
			System.out.println("Has pulsado ok, tu nombre es " + nombre);

		} else {
			System.out.println("Has pulsado cancelar");
		}

	}

}
