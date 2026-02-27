import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CollatzSequenceTest {

    @Test
    public void testNextCollatzPar() {
        assertEquals(3, CollatzSequence.nextCollatz(6)); // 6 → 3
        assertEquals(5, CollatzSequence.nextCollatz(10)); // 10 → 5
        assertEquals(8, CollatzSequence.nextCollatz(16)); // 16 → 8
    }

    @Test
    public void testNextCollatzImpar() {
        assertEquals(10, CollatzSequence.nextCollatz(3)); // 3 → 10
        assertEquals(16, CollatzSequence.nextCollatz(5)); // 5 → 16
        assertEquals(52, CollatzSequence.nextCollatz(17)); // 17 → 52
    }

    @Test
    public void testCalculateCollatzSum() {
        assertEquals(55, CollatzSequence.calculateCollatzSum(6)); // Sequência: 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1, Soma: 55
        assertEquals(259, CollatzSequence.calculateCollatzSum(11)); // Sequência: 11 → 34 → ... → 1, Soma: 284
    }

    @Test
    public void testEntradaInvalida() {
       //assertThrows(IllegalArgumentException.class, () -> CollatzSequence.nextCollatz(0));
       //assertThrows(IllegalArgumentException.class, () -> CollatzSequence.nextCollatz(-5));
       //assertThrows(IllegalArgumentException.class, () -> CollatzSequence.calculateCollatzSum(0));
       //assertThrows(IllegalArgumentException.class, () -> CollatzSequence.calculateCollatzSum(-10));
    }
}
