public class Soma {
    public static void main(String[] args) {
        int[] notas = {8, 6, 10, 7, 9};
        calcularEstatisticas(notas);

        System.out.println("\n--- Teste com array vazio ---");
        int[] notasVazias = {};
        calcularEstatisticas(notasVazias);
    }

    public static void calcularEstatisticas(int[] notas) {
        if (notas.length == 0) {
            System.out.println("SEM NOTAS");
            return;
        }

        int somaForClassico = 0;
        for (int i = 0; i < notas.length; i++) {
            somaForClassico += notas[i];
        }

        int somaForEach = 0;
        for (int nota : notas) {
            somaForEach += nota;
        }

        // Conversão explícita (double) para evitar divisão inteira truncada
        double media = (double) somaForEach / notas.length;

        System.out.println("Soma: " + somaForEach);
        System.out.printf("Média: %.2f%n", media);
    }
}