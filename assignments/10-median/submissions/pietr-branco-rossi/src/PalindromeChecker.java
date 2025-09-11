import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String sequencia;

        while (true) {
            System.out.print("Digite uma sequência: ");
            sequencia = entrada.nextLine();

            if (PalindromeChecker.isValidInput(sequencia)) {
                break; 
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }
        
        entrada.close();

        //---- Chama o método para verificar se é um palíndromo ----//
        if (PalindromeChecker.isPalindrome(sequencia)) {
            System.out.println("A sequência \"" + sequencia + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + sequencia + "\" não é um palíndromo.");
        }
    }
}

public class PalindromeChecker {

    public static boolean isValidInput(String entrada) {
        //---- Retorna falso se a string for nula ou se estiver vazia após remover espaços ----//
        return entrada != null && !entrada.trim().isEmpty();
    }

    public static boolean isPalindrome(String entrada) {
        //---- Converte a string para minúsculas ----//
        String sequenciaLimpa = entrada.toLowerCase();
        int tamanho = sequenciaLimpa.length();

        //---- Loop que vai do início até metade da string ----//
        for (int i = 0; i < tamanho / 2; i++) {
            //---- Compara o caractere do início com o caractere correspondente do fim ----//
            if (sequenciaLimpa.charAt(i) != sequenciaLimpa.charAt(tamanho - 1 - i)) {
                return false;
            }
        }

        //---- Se o loop terminar sem encontrar diferenças, é um palíndromo ----//
        return true;
    }
}
