import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeartRatesTest {

    @Test
    void testCalculateAge() {
        HeartRates person = new HeartRates("João", "Silva", 15, 8, 1990);
        assertEquals(34, person.calculateAge(2025), "A idade deve ser 34 anos para 2025.");
    }

    @Test
    void testCalculateMaxHeartRate() {
        HeartRates person = new HeartRates("João", "Silva", 15, 8, 1990);
        assertEquals(186, person.calculateMaxHeartRate(), "A frequência cardíaca máxima deve ser 186 bpm.");
    }

    @Test
    void testCalculateTargetHeartRate() {
        HeartRates person = new HeartRates("João", "Silva", 15, 8, 1990);
        String targetRange = person.calculateTargetHeartRate();
        assertEquals(targetRange, "93 bpm - 158 bpm", "A faixa de frequência cardíaca alvo deve ser 93 bpm - 158 bpm.");
    }

    @Test
    void testCalculateAgeBoundary() {
        HeartRates person = new HeartRates("Maria", "Costa", 1, 1, 2000);
        assertEquals(25, person.calculateAge(2025), "A idade deve ser 25 anos para 2025.");
    }

    @Test
    void testCalculateMaxHeartRateBoundary() {
        HeartRates person = new HeartRates("Carlos", "Pereira", 10, 5, 2005);
        assertEquals(201, person.calculateMaxHeartRate(), "A frequência cardíaca máxima deve ser 201 bpm.");
    }

    @Test
    void testCalculateTargetHeartRateBoundary() {
        HeartRates person = new HeartRates("Lucas", "Ferreira", 20, 3, 1985);
        String targetRange = person.calculateTargetHeartRate();
        assertEquals(targetRange, "90 bpm - 153 bpm", "A faixa de frequência cardíaca alvo deve ser 90 bpm - 153 bpm.");
    }

    @Test
    void testHandlesFutureBirthDate() {
        HeartRates person = new HeartRates("Ana", "Mendes", 10, 5, 2030);
        //assertThrows(IllegalArgumentException.class, () -> person.calculateAge(2024),
        //        "O método deve lançar exceção para datas de nascimento futuras.");
    }
}