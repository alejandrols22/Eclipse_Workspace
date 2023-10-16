package interfaces.ejemplo1;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPane6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UIManager.put("OptionPane.yesButtonText", "Si");
		UIManager.put("OptionPane.noButtonText", "No");
		
		int opcion = JOptionPane.showConfirmDialog(null, "QUieres continuar",
				"confirmar", JOptionPane.YES_NO_OPTION);
		
		if(opcion == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Has elegido si");
		}
				
	}

}
