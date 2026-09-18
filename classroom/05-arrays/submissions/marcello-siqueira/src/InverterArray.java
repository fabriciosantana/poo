public class InverterArray {

    public static void main(String[] argumentos) {
        int[] origem = {2, 4, 6, 8};
        int[] invertido = inverter(origem);

        System.out.println("Original depois de inverter: " + comoTexto(origem));
        System.out.println("Invertido: " + comoTexto(invertido));

        System.out.println("Tamanho zero: " + comoTexto(inverter(new int[0])));
        System.out.println("Tamanho um: " + comoTexto(inverter(new int[] {5})));
    }

    static int[] inverter(int[] origem) {
        int[] destino = new int[origem.length];

        for (int i = 0; i < origem.length; i++) {
            destino[i] = origem[origem.length - 1 - i];
        }

        return destino;
    }

    static String comoTexto(int[] valores) {
        String texto = "{";

        for (int i = 0; i < valores.length; i++) {
            texto += valores[i];
            if (i < valores.length - 1) {
                texto += ", ";
            }
        }

        return texto + "}";
    }
}
