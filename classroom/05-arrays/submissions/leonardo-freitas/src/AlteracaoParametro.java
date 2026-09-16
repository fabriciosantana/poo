import java.util.Arrays;

public class AlteracaoParametro {
    public static void dobrarPrimeiro(int[] numeros) {
        if (numeros.length > 0) {
            numeros[0] *= 2;
        }
    }

    public static void reatribuir(int[] numeros) {
        numeros = new int[]{99};
    }

    public static void main(String[] args) {
        int[] numeros = {10, 20, 30};
        System.out.println("Antes: " + Arrays.toString(numeros));
        dobrarPrimeiro(numeros);
        System.out.println("Depois de alterar elemento: " + Arrays.toString(numeros));
        reatribuir(numeros);
        System.out.println("Depois de reatribuir parâmetro: " + Arrays.toString(numeros));

        // Alterar um elemento usa a referência recebida para modificar o mesmo array do chamador.
        // Reatribuir o parâmetro muda apenas a cópia local da referência, não a variável do main.
    }
}
