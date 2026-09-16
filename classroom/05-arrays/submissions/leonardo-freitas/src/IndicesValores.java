public class IndicesValores {
    private static void exibir(int[] valores) {
        if (valores.length == 0) {
            System.out.println("ARRAY VAZIO");
            return;
        }
        for (int i = 0; i < valores.length; i++) {
            System.out.println("Índice " + i + ": " + valores[i]);
        }
        System.out.println("Primeiro: " + valores[0]);
        System.out.println("Último: " + valores[valores.length - 1]);
    }

    public static void main(String[] args) {
        int[] valores = {32, 27, 64, 18, 95};
        exibir(valores);
        System.out.println("--- Array com um elemento ---");
        exibir(new int[]{42});
        // valores[valores.length] é inválido porque o último índice válido é length - 1.
    }
}
