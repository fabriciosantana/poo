public class SomaMediaNotas {

    public static void main(String[] argumentos) {
        int[] notas = {8, 6, 10, 7, 9};
        resumir(notas);

        System.out.println();
        resumir(new int[0]);
    }

    static void resumir(int[] notas) {
        if (notas.length == 0) {
            System.out.println("SEM NOTAS");
            return;
        }

        int somaPorIndice = 0;
        for (int i = 0; i < notas.length; i++) {
            somaPorIndice += notas[i];
        }

        int somaPorForEach = 0;
        for (int nota : notas) {
            somaPorForEach += nota;
        }

        System.out.println("Soma: " + somaPorIndice);
        System.out.printf("Média: %.2f%n", (double) somaPorIndice / notas.length);
        System.out.println("Soma com for-each: " + somaPorForEach + " (igual: "
                + (somaPorIndice == somaPorForEach) + ")");
    }
}
