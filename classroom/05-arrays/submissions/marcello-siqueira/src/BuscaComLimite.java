public class BuscaComLimite {

    public static void main(String[] argumentos) {
        int[] valores = {4, 7, 4, 9};

        System.out.println("buscar(4) = " + buscar(valores, 4));
        System.out.println("buscar(9) = " + buscar(valores, 9));
        System.out.println("buscar(5) = " + buscar(valores, 5));

        System.out.println();
        acessar(valores, 2);
        acessar(valores, 0);
        acessar(valores, 4);
        acessar(valores, -1);
    }

    static int buscar(int[] valores, int alvo) {
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == alvo) {
                return i;
            }
        }

        return -1;
    }

    static void acessar(int[] valores, int posicao) {
        if (posicao < 0 || posicao > valores.length - 1) {
            System.out.println("posição " + posicao + ": INDICE INVALIDO");
        } else {
            System.out.println("posição " + posicao + ": " + valores[posicao]);
        }
    }
}
