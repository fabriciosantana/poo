import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeartRatesTest {

    @Test
    void testCalculateAge() {
        HeartRates person = new HeartRates("João", "Silva", 15, 8, 1990);
        assertEquals(34, person.calculateAge(2024), "A idade deve ser 34 anos para 2024.");
    }

    @Test
    void testCalculateMaxHeartRate() {
        HeartRates person = new HeartRates("João", "Silva", 15, 8, 1990);
        assertEquals(186, person.calculateMaxHeartRate(), "A frequência cardíaca máxima deve ser 186 bpm.");
    }

    @Test
    void testCalculateTargetHeartRate() {
        HeartRates person = new HeartRates("João", "Silva", 15, 8, 1990);
        int[] targetRange = person.calculateTargetHeartRate();
        assertEquals(93, targetRange[0], "A frequência alvo mínima deve ser 93 bpm.");
        assertEquals(158, targetRange[1], "A frequência alvo máxima deve ser 158 bpm.");
    }

    @Test
    void testCalculateAgeBoundary() {
        HeartRates person = new HeartRates("Maria", "Costa", 1, 1, 2000);
        assertEquals(24, person.calculateAge(2024), "A idade deve ser 24 anos para 2024.");
    }

    @Test
    void testCalculateMaxHeartRateBoundary() {
        HeartRates person = new HeartRates("Carlos", "Pereira", 10, 5, 2005);
        assertEquals(199, person.calculateMaxHeartRate(), "A frequência cardíaca máxima deve ser 199 bpm.");
    }

    @Test
    void testCalculateTargetHeartRateBoundary() {
        HeartRates person = new HeartRates("Lucas", "Ferreira", 20, 3, 1985);
        int[] targetRange = person.calculateTargetHeartRate();
        assertEquals(92, targetRange[0], "A frequência alvo mínima deve ser 92 bpm.");
        assertEquals(157, targetRange[1], "A frequência alvo máxima deve ser 157 bpm.");
    }

    @Test
    void testHandlesFutureBirthDate() {
        HeartRates person = new HeartRates("Ana", "Mendes", 10, 5, 2030);
        assertThrows(IllegalArgumentException.class, () -> person.calculateAge(2024),
                "O método deve lançar exceção para datas de nascimento futuras.");
    }
}
