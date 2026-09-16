public class FrequenciaDados {
    private static void analisar(int[] resultados) {
        int[] frequencias = new int[6];
        int ignorados = 0;
        for (int resultado : resultados) {
            if (resultado >= 1 && resultado <= 6) {
                frequencias[resultado - 1]++;
            } else {
                ignorados++;
            }
        }
        for (int i = 0; i < frequencias.length; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < frequencias[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("Ignorados: " + ignorados);
    }

    public static void main(String[] args) {
        analisar(new int[]{1, 3, 2, 1, 6, 3, 1, 0, 7});
    }
}
