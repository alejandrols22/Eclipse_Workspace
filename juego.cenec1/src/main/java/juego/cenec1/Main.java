package juego.cenec1;

import java.util.Random;
import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class Main {

    private static final int TABLERO_TAMANO = 10;
    private static char[][] tableroJugador1 = new char[TABLERO_TAMANO][TABLERO_TAMANO];
    private static char[][] tableroJugador2 = new char[TABLERO_TAMANO][TABLERO_TAMANO];
    private static final char VACIO = '~';
    private static final char BARCO = 'B';
    private static final char AGUA = 'A';
    private static final char TOCADO = 'T';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar tableros
        inicializarTablero(tableroJugador1);
        inicializarTablero(tableroJugador2);

        // Jugadores colocan sus barcos
        System.out.println("Jugador 1, coloca tus barcos:");
        colocarFlota(scanner, tableroJugador1);
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n"); // Líneas en blanco para "ocultar" el tablero del Jugador 1

        System.out.println("Jugador 2, coloca tus barcos:");
        colocarFlota(scanner, tableroJugador2);

        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n"); // Líneas en blanco para separar turnos

            // Turnos de los jugadores
            System.out.println("Turno del Jugador 1");
            juegoTerminado = realizarTurno(scanner, tableroJugador2);
            if (juegoTerminado) {
                System.out.println("¡Jugador 1 ha ganado!");
                break;
            }

            System.out.println("Turno del Jugador 2");
            juegoTerminado = realizarTurno(scanner, tableroJugador1);
            if (juegoTerminado) {
                System.out.println("¡Jugador 2 ha ganado!");
            }
        }

        scanner.close();
    }

    public static boolean realizarTurno(Scanner scanner, char[][] tableroOponente) {
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

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < TABLERO_TAMANO; i++) {
            for (int j = 0; j < TABLERO_TAMANO; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    public static void colocarFlota(Scanner scanner, char[][] tablero) {
        int[] tamanos = {2, 3, 4, 5};
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

    public static boolean puedeColocarBarco(int fila, int columna, int tamano, char orientacion, char[][] tablero) {
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

    public static void colocarBarco(int fila, int columna, int tamano, char orientacion, char[][] tablero) {
        for (int i = 0; i < tamano; i++) {
            if (orientacion == 'h') {
                tablero[fila][columna + i] = BARCO;
            } else {
                tablero[fila + i][columna] = BARCO;
            }
        }
    }

    public static boolean comprobarFlotaHundida(char[][] tablero) {
        for (int i = 0; i < TABLERO_TAMANO; i++) {
            for (int j = 0; j < TABLERO_TAMANO; j++) {
                if (tablero[i][j] == BARCO) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < TABLERO_TAMANO; i++) {
            for (int j = 0; j < TABLERO_TAMANO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}


