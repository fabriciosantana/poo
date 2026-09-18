public class AlteracaoPorParametro {

    // Alterar um elemento muda o objeto que o main tambem enxerga, porque as
    // duas variaveis alcancam o mesmo array.
    // Reatribuir o parametro so troca a copia local da referencia: o main
    // continua apontando para o array antigo.

    public static void main(String[] argumentos) {
        int[] numeros = {3, 5, 7};

        System.out.println("Antes: " + comoTexto(numeros));
        dobrarPrimeiro(numeros);
        System.out.println("Depois de dobrarPrimeiro: " + comoTexto(numeros));

        trocarReferencia(numeros);
        System.out.println("Depois de trocarReferencia: " + comoTexto(numeros));

        int[] vazio = new int[0];
        dobrarPrimeiro(vazio);
        System.out.println("Array vazio continua vazio: " + comoTexto(vazio));
    }

    static void dobrarPrimeiro(int[] numeros) {
        if (numeros.length > 0) {
            numeros[0] = numeros[0] * 2;
        }
    }

    static void trocarReferencia(int[] numeros) {
        numeros = new int[] {99};
        System.out.println("Dentro do método, numeros agora é: " + comoTexto(numeros));
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
