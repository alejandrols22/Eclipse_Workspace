package juego.cenec1;

import javax.swing.*;

import java.util.Random;

import java.util.Scanner;

public class Metodos {

	int TABLERO_TAMANO = 10;
	char[][] tableroJugador1 = new char[TABLERO_TAMANO][TABLERO_TAMANO];
	char[][] tableroJugador2 = new char[TABLERO_TAMANO][TABLERO_TAMANO];
	char VACIO = '~';
	char BARCO = 'B';
	char AGUA = 'A';
	char TOCADO = 'T';

	public boolean realizarTurno(Scanner scanner, char[][] tableroOponente) {
		mostrarTablero(tableroOponente);

		System.out.println("Introduce fila (0-9):");
		int fila = scanner.nextInt();
		System.out.println("Introduce columna (0-9):");
		int columna = scanner.nextInt();

		if (tableroOponente[fila][columna] == BARCO) {
			System.out.println("¡Tocado!");
			tableroOponente[fila][columna] = TOCADO;
			if (comprobarFlotaHundida(tableroOponente)) {
				return true;
			}
		} else {
			System.out.println("¡Agua!");
			tableroOponente[fila][columna] = AGUA;
		}
		return false;
	}

	public void inicializarTablero(char[][] tablero) {
		for (int i = 0; i < TABLERO_TAMANO; i++) {
			for (int j = 0; j < TABLERO_TAMANO; j++) {
				tablero[i][j] = VACIO;
			}
		}
	}

	public void colocarFlota(Scanner scanner, char[][] tablero) {
		int[] tamanos = { 2, 3, 4, 5 };
		for (int tamano : tamanos) {
			boolean colocado = false;
			while (!colocado) {
				mostrarTablero(tablero);
				System.out.println("Coloca un barco de tamaño " + tamano);
				System.out.println("Introduce fila inicial (0-9):");
				int fila = scanner.nextInt();
				System.out.println("Introduce columna inicial (0-9):");
				int columna = scanner.nextInt();
				System.out.println("Orientación (h/v):");
				char orientacion = scanner.next().charAt(0);
				if (puedeColocarBarco(fila, columna, tamano, orientacion, tablero)) {
					colocarBarco(fila, columna, tamano, orientacion, tablero);
					colocado = true;
				} else {
					System.out.println("No puedes colocar el barco ahí. Intenta de nuevo.");
				}
			}
		}
	}

	public boolean puedeColocarBarco(int fila, int columna, int tamano, char orientacion, char[][] tablero) {
		if (orientacion == 'h') {
			if (columna + tamano > TABLERO_TAMANO) {
				return false;
			}
			for (int i = 0; i < tamano; i++) {
				if (tablero[fila][columna + i] == BARCO) {
					return false;
				}
			}
		} else {
			if (fila + tamano > TABLERO_TAMANO) {
				return false;
			}
			for (int i = 0; i < tamano; i++) {
				if (tablero[fila + i][columna] == BARCO) {
					return false;
				}
			}
		}
		return true;
	}

	public void colocarBarco(int fila, int columna, int tamano, char orientacion, char[][] tablero) {
		for (int i = 0; i < tamano; i++) {
			if (orientacion == 'h') {
				tablero[fila][columna + i] = BARCO;
			} else {
				tablero[fila + i][columna] = BARCO;
			}
		}
	}

	public boolean comprobarFlotaHundida(char[][] tablero) {
		for (int i = 0; i < TABLERO_TAMANO; i++) {
			for (int j = 0; j < TABLERO_TAMANO; j++) {
				if (tablero[i][j] == BARCO) {
					return false;
				}
			}
		}
		return true;
	}

	public void mostrarTablero(char[][] tablero) {
		for (int i = 0; i < TABLERO_TAMANO; i++) {
			for (int j = 0; j < TABLERO_TAMANO; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}
}
