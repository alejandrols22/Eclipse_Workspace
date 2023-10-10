package ahorcado.ejemplo1;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Random random = new Random();

		String[] palabras = { "manzana", "pera", "balon", "ordenador", "fruta", "guitarra", "bicicleta", "cuchillo",
				"teclado", "radio", "pelota", "silla", "reloj", "mesa", "telefono", "nube", "pantalla", "sol", "luna",
				"estrella", "gato", "perro", "elefante", "tigre", "leopardo", "mariposa", "abeja", "araña", "mosquito",
				"avispa", "lago", "rio", "montaña", "desierto", "volcan", "pizza", "hamburguesa", "sushi", "pasta",
				"ensalada", "rojo", "verde", "azul", "amarillo", "naranja", "invierno", "primavera", "verano", "otoño",
				"lluvia", "avion", "coche", "barco", "bicicleta", "tren", "libro", "revista", "periodico",
				"computadora", "tablet", "cancion", "baile", "pintura", "escultura", "teatro", "familia", "amigos",
				"trabajo", "escuela", "casa", "feliz", "triste", "enojado", "cansado", "emocionado", "amor", "odio",
				"alegria", "paz", "esperanza", "rio", "mar", "oceano", "lago", "cascada", "estudiar", "trabajar",
				"jugar", "viajar", "leer", "cantar", "bailar", "correr", "nadar", "dormir" };

		int indiceAleatorio = random.nextInt(palabras.length);

		String palabraAleatoria = palabras[indiceAleatorio];

		String[] fasesAhorcado = { "+---+\n" + "|   |\n" + "    |\n" + "    |\n" + "    |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "    |\n" + "    |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "    |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "/   |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + " /|   |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "/|\\  |\n" + "    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "/|\\ |\n" + "/    |\n" + "=========",

				"+---+\n" + "|   |\n" + "O   |\n" + "|   |\n" + "/|\\  |\n" + "/ \\  |\n" + "=========" };

		Scanner scanner = new Scanner(System.in);

		char[] palabraGuiones = new char[palabraAleatoria.length()];
		for (int i = 0; i < palabraAleatoria.length(); i++) {
			palabraGuiones[i] = '_';
		}

		byte vidas = 8;
		byte casos = 0;
		do {
			JOptionPane.showMessageDialog(null, "Palabra: " + new String(palabraGuiones));
            JOptionPane.showMessageDialog(null, "Vidas que te quedan: " + vidas);
            String letraInput = JOptionPane.showInputDialog("Dime una letra: ");
            char letra = letraInput.charAt(0);

			boolean letraEncontrada = false;

			for (int i = 0; i < palabraAleatoria.length(); i++) {
				if (palabraAleatoria.charAt(i) == letra) {
					palabraGuiones[i] = letra;
					letraEncontrada = true;
				}
			}

			if (!letraEncontrada) {

				casos++;
				vidas--;
				if (casos < fasesAhorcado.length) {
					JOptionPane.showMessageDialog(null, fasesAhorcado[casos]);
				}

			}

		} while (vidas > 0 && new String(palabraGuiones).contains("_"));

		if (vidas == 0) {
			JOptionPane.showMessageDialog(null, "Perdiste, la palabra era: " + palabraAleatoria);
		} else {
			JOptionPane.showMessageDialog(null, "Lo conseguiste, la palabra es: " + palabraAleatoria);
		}

		scanner.close();
	}
}
