public class SomaMediaNotas {
    private static void analisar(int[] notas) {
        if (notas.length == 0) {
            System.out.println("SEM NOTAS");
            return;
        }
        int somaComIndice = 0;
        for (int i = 0; i < notas.length; i++) {
            somaComIndice += notas[i];
        }
        int somaForEach = 0;
        for (int nota : notas) {
            somaForEach += nota;
        }
        double media = (double) somaComIndice / notas.length;
        System.out.println("Soma: " + somaComIndice);
        System.out.printf("Média: %.2f%n", media);
        System.out.println("Soma com for-each: " + somaForEach);
    }

    public static void main(String[] args) {
        analisar(new int[]{8, 6, 10, 7, 9});
        analisar(new int[0]);
    }
}
