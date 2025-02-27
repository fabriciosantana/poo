import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraIMCTest {

    @Test
    public void testCalcularIMCValoresNormais() {
        assertEquals(16.33, CalculadoraIMC.calcularIMC(50, 1.75), 0.01);
        assertEquals(19.59, CalculadoraIMC.calcularIMC(60, 1.75), 0.01);
        assertEquals(22.86, CalculadoraIMC.calcularIMC(70, 1.75), 0.01);
        assertEquals(26.12, CalculadoraIMC.calcularIMC(80, 1.75), 0.01);
        assertEquals(31.02, CalculadoraIMC.calcularIMC(95, 1.75), 0.01);
        assertEquals(35.92, CalculadoraIMC.calcularIMC(110, 1.75), 0.01);
        assertEquals(39.18, CalculadoraIMC.calcularIMC(120, 1.75), 0.01);
        assertEquals(42.45, CalculadoraIMC.calcularIMC(130, 1.75), 0.01);
    }

    @Test
    public void testClassificacaoIMC() {
        assertEquals("Abaixo do peso", CalculadoraIMC.classificarIMC(16.33));
        assertEquals("Eutrófico", CalculadoraIMC.classificarIMC(22.86));
        assertEquals("Sobrepeso", CalculadoraIMC.classificarIMC(26.12));
        assertEquals("Obesidade Grau I", CalculadoraIMC.classificarIMC(31.02));
        assertEquals("Obesidade Grau II", CalculadoraIMC.classificarIMC(35.92));
        assertEquals("Obesidade Grau III", CalculadoraIMC.classificarIMC(42.45));
    }

    @Test
    public void testValoresInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(-10, 1.75));
        assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(70, -1.75));
        assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(0, 1.75));
    }
}
