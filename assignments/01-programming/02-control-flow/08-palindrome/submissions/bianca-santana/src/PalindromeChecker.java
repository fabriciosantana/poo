import java.util.Scanner;

public class PalindromeChecker {
    
    public static boolean isValidInput(String input) {
        if(input == null || input.isBlank()) {
            return false;

        }

        return true;
    }

    public static boolean isPalindrome(String input) {
        String sequencia = input.replace(" ","").toLowerCase();

        for(int i = 0, j = sequencia.length() - 1; i < j; i++, j-- ){
            if(sequencia.charAt(i) != sequencia.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        System.out.printf("Digite uma sequência: ");
        String sequencia = ler.nextLine();

        while(isValidInput(sequencia) == false){
            System.out.println("Erro: A entrada não pode estar vazia.");
            System.out.printf("Digite uma sequência: ");
            sequencia = ler.nextLine();
        } 

        if(isPalindrome(sequencia) == false){
            System.out.printf("A sequência \"%s\" não é um palíndromo.", sequencia.replace(" ",""));

        } else {
            System.out.printf("A sequência \"%s\" é um palíndromo.", sequencia.replace(" ",""));
        }

    }






}
