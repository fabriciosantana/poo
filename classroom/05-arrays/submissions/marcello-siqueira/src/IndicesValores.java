public class IndicesValores {

    public static void main(String[] argumentos) {
        int[] valores = {32, 27, 64, 18, 95};
        exibir(valores);

        int[] unico = {7};
        System.out.println();
        exibir(unico);

        System.out.println();
        System.out.println("valores[valores.length] é inválido porque os índices vão de 0 a length - 1.");
        System.out.println("Com length = " + valores.length + ", o último índice é " + (valores.length - 1)
                + ", então a posição " + valores.length + " está fora do array.");
    }

    static void exibir(int[] valores) {
        if (valores.length == 0) {
            System.out.println("ARRAY VAZIO");
            return;
        }

        for (int i = 0; i < valores.length; i++) {
            System.out.println("índice " + i + ": " + valores[i]);
        }

        System.out.println("Primeiro: " + valores[0]);
        System.out.println("Último: " + valores[valores.length - 1]);
    }
}
