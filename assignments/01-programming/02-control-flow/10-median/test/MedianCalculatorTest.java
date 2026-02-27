import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class MedianCalculatorTest {

    @ParameterizedTest
    @CsvSource({
        // Casos com três números distintos
        "7, 2, 5, 5",      // Ordem: 7,2,5  → mediana: 5
        "2, 7, 5, 5",      // Ordem: 2,7,5  → mediana: 5
        "5, 2, 7, 5",      // Ordem: 5,2,7  → mediana: 5
        
        // Casos com números duplicados
        "2, 2, 7, 2",      // Dois 2's e um 7 → mediana: 2
        "7, 2, 2, 2",      // Dois 2's → mediana: 2
        "7, 7, 2, 7",      // Dois 7's e um 2 → mediana: 7
        "7, 7, 7, 7",      // Todos iguais → mediana: 7
        
        // Outro exemplo com duplicados
        "10, 5, 5, 5"      // Dois 5's e um 10 → mediana: 5
    })
    void testFindMedian(int a, int b, int c, int expectedMedian) {
        assertEquals(expectedMedian, MedianCalculator.findMedian(a, b, c),
            String.format("Para os valores (%d, %d, %d) a mediana deve ser %d", a, b, c, expectedMedian));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-10, MedianCalculator.findMedian(-10, -5, -20),
            "Para os valores (-10, -5, -20) a mediana deve ser -10");
    }
}
