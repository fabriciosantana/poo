import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HealthProfileTest {

    HealthProfile person = new HealthProfile("João", "Silva", 'M', 15, 8, 1990, 70, 180);

    @Test
    public void testCalculoIdade() {
        assertEquals(34, person.calculateAge(2025));
    }

    @Test
    public void testCalculoFrequenciaMaxima() {
        assertEquals(186, person.calculateMaxHeartRate());
    }

    @Test
    public void testCalculoFaixaFrequencia() {
        assertEquals("93 bpm - 158 bpm", person.calculateTargetHeartRate());
    }

    @Test
    public void testCalculoBMI() {
        assertEquals(25.8, person.calculateBMI(), 0.1);
    }

    @Test
    public void testIdadeMinimaLimite() {
        HealthProfile baby = new HealthProfile("Bebê", "Nascimento", 'M', 1, 1, 2024, 20, 10);
        assertEquals(1, baby.calculateAge(2025));
    }

    @Test
    public void testGeneroMasculino() {
        assertEquals('M', person.getGender());
    }

    @Test
    public void testGeneroFeminino() {
        HealthProfile personF = new HealthProfile("Maria", "Oliveira", 'F', 10, 5, 1985, 65, 150);
        assertEquals('F', personF.getGender());
    }
}
