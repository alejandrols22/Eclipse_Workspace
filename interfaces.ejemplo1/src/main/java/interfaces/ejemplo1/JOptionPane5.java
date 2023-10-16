package interfaces.ejemplo1;

import javax.swing.JOptionPane;

public class JOptionPane5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int codigo = JOptionPane.showConfirmDialog(null,
				"La verdad esta ante tus ojos doname un euro y te la dire","La verdad",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if(codigo != JOptionPane.YES_OPTION) {
			System.out.println("Mbappe jugara en Madrid en el 2028");
		}else if (codigo != JOptionPane.NO_OPTION) {
			System.out.println("Los masones van a matarte");
		}
	}

}
