package ahorcado.ejemplo1;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Random random = new Random();

		JOptionPane.showMessageDialog(null, 
				"Bienvenido al Juego del Ahorcado ","Bienvenido", 
				JOptionPane.INFORMATION_MESSAGE);
		
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

		char[] palabraGuiones = new char[palabraAleatoria.length()]; // Array de char de la palabra usada en guiones
		for (int i = 0; i < palabraAleatoria.length(); i++) { // Bucle for que convierte la palabra original en guiones
																// para que el usuario no pueda saber cual es la palabra
			palabraGuiones[i] = '_';
		}

		byte vidas = 8; // intentos del usuario
		byte casos = 0; // fases del ahorcado para que cada vez que el usuario avance se muestre una
						// nueva fase
		do {
			JOptionPane.showMessageDialog(null, "Palabra: " + new String(palabraGuiones));
			JOptionPane.showMessageDialog(null, "Vidas que te quedan: " + vidas);
			
			String letraInput = JOptionPane.showInputDialog("Dime una letra: ");
			char letra = letraInput.toLowerCase().charAt(0); // Convertimos la letra ingresada a minúsculas

			boolean letraEncontrada = false;

			for (int i = 0; i < palabraAleatoria.length(); i++) {
			    if (palabraAleatoria.charAt(i) == letra || palabraAleatoria.toLowerCase().charAt(i) == letra) { // Convertimos la letra de la palabra a minúscula para la comparación
			        palabraGuiones[i] = palabraAleatoria.charAt(i); // Aquí es importante no cambiar la letra original a minúscula, ya que queremos que se muestre tal cual es en la palabra original
			        letraEncontrada = true;
			    }
			}
			

			if (!letraEncontrada) { // Condicional que sucede si no existe ninguna letra que coincida con la palabra
									// original

				casos++; // Se suma un caso para que se muestre la siguiente fase del ahorcado
				vidas--; // Se resta una vida para que el usuario tenga un intento menos
				if (casos < fasesAhorcado.length) {
					JOptionPane.showMessageDialog(null, fasesAhorcado[casos]);
				}

			}

		} while (vidas > 0 && new String(palabraGuiones).contains("_")); // El bucle seguira funcionando hasta que las
																			// vidas sean mayores a 0 y la palabra en
																			// guiones sigue teniendo un guion

		if (vidas == 0) { // si las vidas es igual a 0 se muestra un mensaje de derrota
			JOptionPane.showMessageDialog(null, "Perdiste, la palabra era: " + palabraAleatoria);
		} else { // Se ha adivinado la palabra y se muestra un mensaje de victoria
			JOptionPane.showMessageDialog(null, "Lo conseguiste, la palabra es: " + palabraAleatoria);
		}

		scanner.close();
	}
}
