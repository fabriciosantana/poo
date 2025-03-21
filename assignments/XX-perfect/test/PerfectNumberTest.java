import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class PerfectNumberTest {

    @Test
    public void testPerfectNumbers() {
        assertTrue(PerfectNumber.isPerfect(6));  // 6 é perfeito
        assertTrue(PerfectNumber.isPerfect(28)); // 28 é perfeito
        assertTrue(PerfectNumber.isPerfect(496)); // 496 é perfeito
        assertTrue(PerfectNumber.isPerfect(8128)); // 8128 é perfeito
    }

    @Test
    public void testNonPerfectNumbers() {
        assertFalse(PerfectNumber.isPerfect(5));  // 5 não é perfeito
        assertFalse(PerfectNumber.isPerfect(10)); // 10 não é perfeito
        assertFalse(PerfectNumber.isPerfect(50)); // 50 não é perfeito
        assertFalse(PerfectNumber.isPerfect(100)); // 100 não é perfeito
    }

    @Test
    public void testFactors() {
        assertEquals(List.of(1, 2, 3), PerfectNumber.getFactors(6)); 
        assertEquals(List.of(1, 2, 4, 7, 14), PerfectNumber.getFactors(28));
        assertEquals(List.of(1, 2, 4, 8, 16, 31, 62, 124, 248), PerfectNumber.getFactors(496));
    }

    @Test
    public void testNegativeAndZero() {
        assertFalse(PerfectNumber.isPerfect(0));  // Zero não é perfeito
        assertFalse(PerfectNumber.isPerfect(-6)); // Números negativos não são perfeitos
    }
}
