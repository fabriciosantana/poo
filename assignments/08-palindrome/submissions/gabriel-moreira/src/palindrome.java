import java.util.Scanner;

public class PalindromeChecker {

    
    public static boolean entradaValida(String texto) {
        if (texto == null) return false;
        return !texto.trim().isEmpty();
    }

    
    public static boolean verificarPalindromo(String texto) {
        String tratado = texto.toLowerCase().replaceAll("\\s+", "");
        int i = 0;
        int j = tratado.length() - 1;

        while (i < j) {
            if (tratado.charAt(i) != tratado.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String texto;

        while (true) {
            System.out.print("Digite uma sequência: ");
            texto = teclado.nextLine();

            if (!entradaValida(texto)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                break;
            }
        }

        if (verificarPalindromo(texto)) {
            System.out.println("A sequência \"" + texto + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + texto + "\" não é um palíndromo.");
        }

        teclado.close();
    }
}
