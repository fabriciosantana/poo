
import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isValidInput(String input){
        return input != null && !input.trim().isEmpty();
    }
    
    public static boolean isPalindrome(String input){
        String processedInput = input.toLowerCase();

        String fixedInput = processedInput.replaceAll("[^a-z0-9]", "");

        int length = fixedInput.length();
        int left = 0;
        int right = length - 1;

        while(left < right){
            if(fixedInput.charAt(left) != fixedInput.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while(true){
            System.out.print("Digite uma sequência: ");
            userInput = scanner.nextLine();
            
            if(isValidInput(userInput)){
                break;
            }
            else{
                System.out.print("\nErro: A entrada não pode estar vazia.\n");
            }
        }

        if(isPalindrome(userInput)){
            System.out.printf("A sequência \"%s\" é um palíndromo.", userInput);
        }
        else{
            System.out.printf("A sequência \"%s\" não é um palíndromo.", userInput);
        }
        scanner.close();
    }
}
