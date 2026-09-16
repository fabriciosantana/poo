public class ExtremosTemperaturas {
    private static void analisar(int[] temperaturas) {
        if (temperaturas.length == 0) {
            System.out.println("SEM TEMPERATURAS");
            return;
        }
        int maior = temperaturas[0];
        int menor = temperaturas[0];
        int indiceMaior = 0;
        int indiceMenor = 0;
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > maior) {
                maior = temperaturas[i];
                indiceMaior = i;
            }
            if (temperaturas[i] < menor) {
                menor = temperaturas[i];
                indiceMenor = i;
            }
        }
        System.out.println("Maior: " + maior + " (índice " + indiceMaior + ")");
        System.out.println("Menor: " + menor + " (índice " + indiceMenor + ")");
    }

    public static void main(String[] args) {
        analisar(new int[]{23, 18, 26, 18, 21});
        analisar(new int[0]);
    }
}
