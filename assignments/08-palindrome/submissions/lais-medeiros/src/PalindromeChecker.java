public class PalindromeChecker {

    // Verifica se a entrada é válida (não nula nem só espaços)
    public static boolean isValidInput(String input) {
        if (input == null) return false;
        return !input.trim().isEmpty();
    }

    // Verifica se é palíndromo
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
