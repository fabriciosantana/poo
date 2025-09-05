public class PalindromeChecker {

    public static boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }

        String cleanedText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (cleanedText.isEmpty()) {
            return false;
        }

        String reversedText = new StringBuilder(cleanedText).reverse().toString();

        return cleanedText.equals(reversedText);
    }

    public static void main(String[] args) {
        String[] testCases = {
            "racecar",
            "MaDaM",
            "A man a plan a canal Panama",
            "12321",
            "hello",
            "a"
        };

        System.out.println("--- Verificador de Palíndromos ---");
        for (String testCase : testCases) {
            boolean result = isPalindrome(testCase);
            System.out.println("'" + testCase + "' é um palíndromo? " + result);
        }
        System.out.println("------------------------------------");
    }
}