import java.util.Scanner;
//02-03
public class PalindromeChecker {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String Original;
        String Invertido = "";

        System.out.print("Digite uma Sequência: ");
        Original = scanner.nextLine();
        if (!isValidInput(Original))
        {
            System.out.println("Erro: A entrada não pode estar vazia.");
            return;
        }

        if (isPalindrome(Original, Invertido))
        {
            System.out.println("A sequência \"" + Original + "\" é um palíndromo.");
        }
        else
        {
            System.out.println("A sequência \"" + Original + "\" não é um palíndromo.");
        }

    }
    public static boolean isValidInput(String Original){
        if( Original == null) return false;
            Original = Original.trim();
            return !Original.isEmpty();
        }

    public static boolean isPalindrome(String Original, String Invertido){

        Original = Original.toLowerCase();
        for(int i = Original.length()-1; i>=0; i--){
            
            Invertido += Original.charAt(i);
        }
        
        Original.equals(Invertido);
        return true;
    }

}
