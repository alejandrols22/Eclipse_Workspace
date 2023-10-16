package interfaces.ejemplo1;

import javax.swing.JOptionPane;

public class JOptionPane3 {

	public static void main(String[] args) {
		int codigo = JOptionPane.showConfirmDialog(null, "¿Quieres un euro para un churro con chocolate", "Donacion",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (codigo == JOptionPane.YES_OPTION) {
			System.out.println("Toma este churro que me ha salido pocho");
		} else if (codigo == JOptionPane.NO_OPTION) {
			System.out.println("Madre mia, que rata eres");

		} else {
			System.out.println("Ya veo, que pasas de movidas");
		}

	}
}
