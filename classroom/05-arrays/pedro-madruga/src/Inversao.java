public class Inversao {
    public static void main(String[] args) {
        int[] origem = {2, 4, 6, 8};
        int[] invertido = inverter(origem);

        System.out.print("Origem: ");
        imprimir(origem);

        System.out.print("Invertido: ");
        imprimir(invertido);

        // Testes de fronteira: 0 e 1 elemento
        imprimir(inverter(new int[]{}));
        imprimir(inverter(new int[]{42}));
    }

    public static int[] inverter(int[] origem) {
        int[] destino = new int[origem.length];
        for (int i = 0; i < origem.length; i++) {
            destino[i] = origem[origem.length - 1 - i];
        }
        return destino;
    }

    private static void imprimir(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}