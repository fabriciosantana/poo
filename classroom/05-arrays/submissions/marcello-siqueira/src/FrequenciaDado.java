public class FrequenciaDado {

    public static void main(String[] argumentos) {
        contar(new int[] {1, 3, 2, 1, 6, 3, 1});

        System.out.println();
        contar(new int[] {1, 0, 4, 7, 4, 6});
    }

    static void contar(int[] resultados) {
        int[] frequencias = new int[6];
        int ignorados = 0;

        for (int resultado : resultados) {
            if (resultado < 1 || resultado > 6) {
                ignorados++;
            } else {
                frequencias[resultado - 1]++;
            }
        }

        for (int face = 1; face <= frequencias.length; face++) {
            String barras = "";
            for (int i = 0; i < frequencias[face - 1]; i++) {
                barras += "*";
            }
            System.out.println(face + ": " + barras);
        }

        System.out.println("Registros ignorados: " + ignorados);
    }
}
