public class Alteracao {
    public static void main(String[] args) {
        int[] dados = {10, 20, 30};

        System.out.println("Antes de dobrarPrimeiro: " + dados[0]);
        dobrarPrimeiro(dados);
        System.out.println("Depois de dobrarPrimeiro: " + dados[0]); // Modificado para 20

        System.out.println("\nAntes de tentarReatribuir: " + dados[0]);
        tentarReatribuir(dados);
        System.out.println("Depois de tentarReatribuir: " + dados[0]); // Mantém o 20
    }

    public static void dobrarPrimeiro(int[] numeros) {
        if (numeros.length > 0) {
            numeros[0] *= 2;
        }
    }

    public static void tentarReatribuir(int[] numeros) {
        numeros = new int[] {99};
    }

    /*
     * Explicação:
     * Java trabalha exclusivamente com passagem por valor.
     * Quando um array é passado para um método, o parâmetro recebe uma cópia do endereço
     * de memória (a referência).
     *
     * 1. Alterar um elemento (numeros[0] = ...): acessa e modifica diretamente a área
     *    de memória compartilhada pelo chamador e pelo método.
     * 2. Reatribuir o parâmetro (numeros = new int[]...): apenas faz a variável local
     *    'numeros' apontar para outro objeto na memória, deixando intacta a referência
     *    original mantida pela variável 'dados' no método main.
     */
}