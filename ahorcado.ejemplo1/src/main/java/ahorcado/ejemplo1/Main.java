package ahorcado.ejemplo1;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {

		Random random = new Random();

		// Cambiamos el idioma de los botones a español
		UIManager.put("OptionPane.okButtonText", "Aceptar");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");

		JOptionPane.showMessageDialog(null, "Bienvenido al Juego del Ahorcado ", "Bienvenido",
				JOptionPane.INFORMATION_MESSAGE);

		String[] palabras = { "manzana", "pera", "balon", "ordenador", "fruta", "guitarra", "bicicleta", "cuchillo",
				"teclado", "radio", "pelota", "silla", "reloj" };
		// Array de las posibles palabras que va a usar el ahorcado

		int indiceAleatorio = random.nextInt(palabras.length); // numero del array de palabras que va a escoger en el
																// juego

		String palabraAleatoria = palabras[indiceAleatorio]; // palabra que se utilizara en el juego

		String[] fasesAhorcado = { "+---+\n" + "|   |\n" + "    |\n" + "    |\n" + "    |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "    |\n" + "    |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "    |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "/   |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + " /|   |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "/|\\  |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "/|\\ |\n" + "/    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "/|\\  |\n" + "/ \\  |\n" + "=========" };

		// Array que guarda las fases del dibujo del ahorcado

		Scanner scanner = new Scanner(System.in);

		char[] palabraGuiones = new char[palabraAleatoria.length()];
		for (int i = 0; i < palabraAleatoria.length(); i++) {
			palabraGuiones[i] = '_';
		}

		byte vidas = 8;
		byte casos = 0; // fases del ahorcado para que cada vez que el usuario avance se muestre una
						// nueva fase
		do {
			JOptionPane.showMessageDialog(null, "Palabra: " + new String(palabraGuiones));
			JOptionPane.showMessageDialog(null, "Vidas restantes: " + vidas);

			String entrada = (String) JOptionPane.showInputDialog(null, "Introduce una letra o la palabra completa:",
					"Entrada", JOptionPane.QUESTION_MESSAGE, null, null, "");

			if (entrada == null) {
				JOptionPane.showMessageDialog(null, "Espero que te hayas divertido");
				System.exit(0);
			}

			entrada = entrada.toLowerCase();

			if (entrada.length() > 1) {
				if (entrada.equals(palabraAleatoria)) {
					palabraGuiones = entrada.toCharArray();
					break;
				} else {
					vidas--;
					JOptionPane.showMessageDialog(null, "¡Incorrecto! Pierdes una vida.");
				}
			} else {
				char letra = entrada.charAt(0);
				boolean letraEncontrada = false;

				for (int i = 0; i < palabraAleatoria.length(); i++) {
					if (palabraAleatoria.charAt(i) == letra) {
						palabraGuiones[i] = letra;
						letraEncontrada = true;
					}
				}

				if (!letraEncontrada) { // se resta una vida y se suma una fase del ahorcado
					casos++;
					vidas--;
					if (casos < fasesAhorcado.length) {
						JOptionPane.showMessageDialog(null, fasesAhorcado[casos]);
					}
				}
			}

		} while (vidas > 0 && new String(palabraGuiones).contains("_"));

		if (new String(palabraGuiones).contains("_")) {
			JOptionPane.showMessageDialog(null, "Has perdido, la palabra era: " + palabraAleatoria);
		} else {
			JOptionPane.showMessageDialog(null, "¡Lo lograste! La palabra es: " + palabraAleatoria);
		}
	}
}