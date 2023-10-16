package interfaces.ejemplo1;

import javax.swing.JOptionPane;

public class JOptionPane5 {

	public static void main(String[] args) {
		
		int codigo = JOptionPane.showConfirmDialog(null, "La verdad esta ante tus ojos doname un euro y te la dire",
				"La verdad", JOptionPane.YES_NO_CANCEL_OPTION);
		if (codigo != JOptionPane.YES_OPTION) {
			System.out.println("Has dicho que si, pero me da pereza decirte algo");
		} else if (codigo != JOptionPane.NO_OPTION) {
			System.out.println("La verdad esta muy cerca, pero no quieres verla");
		}
	}

}
