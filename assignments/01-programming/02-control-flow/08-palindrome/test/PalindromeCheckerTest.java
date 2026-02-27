import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckerTest {

    @Test
    public void testPalindromoSimples() {
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome("madam"));
    }

    @Test
    public void testPalindromoNumerico() {
        assertTrue(PalindromeChecker.isPalindrome("12321"));
        assertTrue(PalindromeChecker.isPalindrome("2002"));
    }

    @Test
    public void testNaoPalindromo() {
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("java"));
    }

    @Test
    public void testPalindromoCaseInsensitive() {
        assertTrue(PalindromeChecker.isPalindrome("RaceCar"));
        assertTrue(PalindromeChecker.isPalindrome("MaDaM"));
    }

    @Test
    public void testPalindromoComEspacos() {
        assertTrue(PalindromeChecker.isPalindrome("nurses run"));
        assertTrue(PalindromeChecker.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    public void testPalindromoLimite() {
        assertTrue(PalindromeChecker.isPalindrome("a"));  // Caso de menor tamanho possível
        assertFalse(PalindromeChecker.isPalindrome("ab"));
    }

    @Test
    public void testEntradaInvalida() {
        //assertFalse(PalindromeChecker.isPalindrome(""));
        //assertFalse(PalindromeChecker.isPalindrome("   "));
        //assertFalse(PalindromeChecker.isPalindrome(null));
    }
}
