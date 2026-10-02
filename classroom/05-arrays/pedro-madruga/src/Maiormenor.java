public class Maiormenor {
    public static void main(String[] args) {
        int[] temperaturas = {23, 18, 26, 18, 21};
        analisarTemperaturas(temperaturas);

        System.out.println("\n--- Teste com array vazio ---");
        int[] vazio = {};
        analisarTemperaturas(vazio);
    }

    public static void analisarTemperaturas(int[] temps) {
        if (temps.length == 0) {
            System.out.println("SEM TEMPERATURAS");
            return;
        }

        int maior = temps[0];
        int indiceMaior = 0;

        int menor = temps[0];
        int indiceMenor = 0;

        // Comparações estritas (>) e (<) garantem que mantemos a PRIMEIRA ocorrência
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] > maior) {
                maior = temps[i];
                indiceMaior = i;
            }
            if (temps[i] < menor) {
                menor = temps[i];
                indiceMenor = i;
            }
        }

        System.out.printf("Maior: %d (índice %d)%n", maior, indiceMaior);
        System.out.printf("Menor: %d (índice %d)%n", menor, indiceMenor);
    }
}