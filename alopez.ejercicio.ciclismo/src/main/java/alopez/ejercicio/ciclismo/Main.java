package alopez.ejercicio.ciclismo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre de la competición:");
        String nombreCompeticion = scanner.nextLine();

        while (!Metodos.esNombreValido(nombreCompeticion)) {
            System.out.println("El nombre introducido no esta permitido. Introduce un nombre que empiece por 'Vuelta' y tenga al menos dos espacios:");
            nombreCompeticion = scanner.nextLine();
        }

        nombreCompeticion = Metodos.convertirVocalesAMayusculas(nombreCompeticion);
        System.out.println("El nombre modificado es: " + nombreCompeticion);

        int cuentaNoLetras = Metodos.contarNoLetras(nombreCompeticion);
        System.out.println("El nombre tiene " + cuentaNoLetras + " caracteres que no son letras mayúsculas ni minúsculas.");

        System.out.println("Introduce el número de etapas que tendrá la competición:");
        int numEtapas = scanner.nextInt();

        short[] etapas = new short[numEtapas];

        // Llenamos el array etapas con longitudes aleatorias entre 80 y 200 km.
        Metodos.llenarEtapasConKilometros(etapas);

        //Imprimir las longitudes para verificación.
        for (int i = 0; i < etapas.length; i++) {
            System.out.println("Etapa " + (i + 1) + ": " + etapas[i] + " km");
        }

        // Usamos la función recursiva para calcular e imprimir la distancia total.
        short distanciaTotalRecursiva = Metodos.cuentaKilometros(etapas, 0, 0);
        System.out.println("La distancia total a recorrer entre todas las etapas es: " + distanciaTotalRecursiva + " km");

        short distanciaEtapaMasLarga = Metodos.etapaMasLarga(etapas);
        System.out.println("La distancia de la etapa más larga es: " + distanciaEtapaMasLarga + " km");

        // Declarar el array corredores
        String[] corredores = new String[etapas.length + 1];
        
        for (int i = 0; i < corredores.length; i++) {
            corredores[i] = "Corredor " + (i + 1);
        }

        // Simulación de la competición
        for (int etapa = 0; etapa < etapas.length; etapa++) {
            System.out.println("\nEtapa " + (etapa + 1));
            String corredorEliminado = Metodos.simularEtapaYDevolverEliminado(corredores);
            System.out.println("El corredor eliminado en esta etapa es: " + corredorEliminado);
        }

        System.out.println("\nEl ganador de la competición es: " + corredores[0]);
    }
    

}
