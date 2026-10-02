public class Frequencia {
    public static void main(String[] args) {
        int[] resultados = {1, 3, 2, 1, 6, 3, 1, 0, 7, 3};
        
        // 6 posições para as faces de 1 a 6
        int[] contadores = new int[6];
        int ignorados = 0;

        for (int lancamento : resultados) {
            // Valida se o valor está no intervalo de 1 a 6
            if (lancamento >= 1 && lancamento <= 6) {
                contadores[lancamento - 1]++;
            } else {
                ignorados++;
            }
        }

        for (int i = 0; i < contadores.length; i++) {
            int face = i + 1;
            System.out.print(face + ": ");
            for (int barra = 0; barra < contadores[i]; barra++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Lançamentos inválidos ignorados: " + ignorados);
    }
}