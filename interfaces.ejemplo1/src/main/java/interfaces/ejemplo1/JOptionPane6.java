package interfaces.ejemplo1;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPane6 {

	public static void main(String[] args) {
		// Configura los textos de los botones en español
		UIManager.put("OptionPane.yesButtonText", "Si");
		UIManager.put("OptionPane.noButtonText", "No");

		int opcion = JOptionPane.showConfirmDialog(null, "Quieres continuar", "confirmar",
				JOptionPane.YES_NO_CANCEL_OPTION);

		if (opcion == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Has elegido si");
		} else if (opcion == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Has elegido no");

		} else {
			JOptionPane.showMessageDialog(null, "Aclarate anda");

		}

	}

}
