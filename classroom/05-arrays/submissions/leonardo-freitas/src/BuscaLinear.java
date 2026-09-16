public class BuscaLinear {
    public static int buscar(int[] valores, int alvo) {
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == alvo) {
                return i;
            }
        }
        return -1;
    }

    private static void acessarPosicao(int[] valores, int posicao) {
        if (posicao < 0 || posicao >= valores.length) {
            System.out.println("INDICE INVALIDO");
            return;
        }
        System.out.println("Valor na posição " + posicao + ": " + valores[posicao]);
    }

    public static void main(String[] args) {
        int[] valores = {4, 7, 4, 9};
        System.out.println("4 -> " + buscar(valores, 4));
        System.out.println("9 -> " + buscar(valores, 9));
        System.out.println("5 -> " + buscar(valores, 5));
        acessarPosicao(valores, 2);
        acessarPosicao(valores, valores.length);
    }
}
