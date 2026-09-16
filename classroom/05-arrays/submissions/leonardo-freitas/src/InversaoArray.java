import java.util.Arrays;

public class InversaoArray {
    public static int[] inverter(int[] origem) {
        int[] invertido = new int[origem.length];
        for (int i = 0; i < origem.length; i++) {
            invertido[i] = origem[origem.length - 1 - i];
        }
        return invertido;
    }

    public static void main(String[] args) {
        int[] origem = {2, 4, 6, 8};
        System.out.println("Original: " + Arrays.toString(origem));
        System.out.println("Invertido: " + Arrays.toString(inverter(origem)));
        System.out.println("Original depois: " + Arrays.toString(origem));
        System.out.println("Vazio: " + Arrays.toString(inverter(new int[0])));
        System.out.println("Um elemento: " + Arrays.toString(inverter(new int[]{5})));
    }
}
