package interfaces.ejemplo1;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		//null indica que es independiente y no esta vinculado a ninguna ventana
		String nombre = "Alberto";
		JOptionPane.showMessageDialog(null, 
				"Su ordenador tiene un Ransomware ","Error grave", 
				JOptionPane.INFORMATION_MESSAGE);
	}

}
