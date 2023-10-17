package alopez.ejercicio.ciclismo;

import java.util.Random;

public class Metodos {

    public static boolean esNombreValido(String nombre) {
        return nombre.startsWith("Vuelta") && nombre.chars().filter(ch -> ch == ' ').count() >= 2;
    }

    public static String convertirVocalesAMayusculas(String input) {
        return input.replaceAll("a", "A")
                .replaceAll("e", "E")
                .replaceAll("i", "I")
                .replaceAll("o", "O")
                .replaceAll("u", "U");
    }

    public static int contarNoLetras(String texto) {
        int cuenta = 0;
        for (char c : texto.toCharArray()) {
            if (!Character.isUpperCase(c) && !Character.isLowerCase(c)) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public static void llenarEtapasConKilometros(short[] etapas) {
        Random random = new Random();
        for (int i = 0; i < etapas.length; i++) {
            etapas[i] = (short) (random.nextInt(121) + 80);  // Genera un número aleatorio entre 80 y 200 .
        }
    }

    public static short cuentaKilometros(short[] etapas, int index, int acumulado) {
        if (index == etapas.length) {
            return (short) acumulado;
        }
        return cuentaKilometros(etapas, index + 1, acumulado + etapas[index]);
    }

    public static short etapaMasLarga(short[] etapas) {
        short max = 0;
        for (short etapa : etapas) {
            if (etapa > max) {
                max = etapa;
            }
        }
        return max;
    }
    
    public static String simularEtapaYDevolverEliminado(String[] corredores) {
        Random random = new Random();
        int indiceEliminado;

        // Evitar seleccionar un corredor que ya fue eliminado (es decir, su valor es null).
        do {
            indiceEliminado = random.nextInt(corredores.length);
        } while (corredores[indiceEliminado] == null);

        String corredorEliminado = corredores[indiceEliminado];

        // Reorganizar el array para eliminar el corredor
        for (int i = indiceEliminado; i < corredores.length - 1; i++) {
            corredores[i] = corredores[i + 1];
        }
        corredores[corredores.length - 1] = null; // Establecer el último corredor como null después de la reorganización

        return corredorEliminado;
    }

}
