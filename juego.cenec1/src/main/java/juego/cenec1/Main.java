package juego.cenec1;

import java.util.Random;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Metodos metodos = new Metodos();
		Scanner scanner = new Scanner(System.in);

		// Inicializar tableros
		metodos.inicializarTablero(metodos.tableroJugador1);
		metodos.inicializarTablero(metodos.tableroJugador2);

		// Jugadores colocan sus barcos
		System.out.println("Jugador 1, coloca tus barcos:");
		metodos.colocarFlota(scanner, metodos.tableroJugador1);

		System.out.println("\n\n\n\n\n\n\n\n\n\n"); // Líneas en blanco para "ocultar" el tablero del Jugador 1

		System.out.println("Jugador 2, coloca tus barcos:");
		metodos.colocarFlota(scanner, metodos.tableroJugador2);

		boolean juegoTerminado = false;
		while (!juegoTerminado) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n"); // Líneas en blanco para separar turnos

			// Turnos de los jugadores
			System.out.println("Turno del Jugador 1");
			juegoTerminado = metodos.realizarTurno(scanner, metodos.tableroJugador2);
			if (juegoTerminado) {
				System.out.println("¡Jugador 1 ha ganado!");
				break;
			}

			System.out.println("Turno del Jugador 2");
			juegoTerminado = metodos.realizarTurno(scanner, metodos.tableroJugador1);
			if (juegoTerminado) {
				System.out.println("¡Jugador 2 ha ganado!");
			}
		}

		scanner.close();
	}
}
