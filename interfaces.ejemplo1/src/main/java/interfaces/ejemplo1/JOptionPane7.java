package interfaces.ejemplo1;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JOptionPane7 {
	public static void main(String[] args) {

		
        UIManager.put("OptionPane.yesButtonText", "Si");
        UIManager.put("OptionPane.noButtonText", "No");

        int opcion = JOptionPane.showConfirmDialog(null, "Quieres continuar",
                "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);

        if(opcion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Has elegido si");
        } else if (opcion == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Has elegido no");
        } else {
            JOptionPane.showMessageDialog(null, "Aclárate anda");
        }

        //dialogo con input
        String input = JOptionPane.showInputDialog(null, "Introduce tu nombre:");
        JOptionPane.showMessageDialog(null, "Hola, " + input + "!");

        
        Object[] options = {"Opción 1", "Opción 2", "Opción 3"};
        int n = JOptionPane.showOptionDialog(null,
            "¿Cuál opción prefieres?",
            "Selección",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[2]);

        
        JOptionPane.showMessageDialog(null, "Esto es una información", "Info", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Esto es un error", "Error", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null, "Esto es una advertencia", "Advertencia", JOptionPane.WARNING_MESSAGE);

        
        JOptionPane.showMessageDialog(null, "Esto es un mensaje simple", "Mensaje", JOptionPane.PLAIN_MESSAGE);
    }
}






