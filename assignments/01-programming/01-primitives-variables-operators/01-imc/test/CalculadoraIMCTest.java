import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraIMCTest {

    @Test
    public void testCalcularIMCValoresNormais() {
        assertEquals(16.33, CalculadoraIMC.calcularIMC(50D, 1.75), 0.01);
        assertEquals(19.59, CalculadoraIMC.calcularIMC(60D, 1.75), 0.01);
        assertEquals(22.86, CalculadoraIMC.calcularIMC(70D, 1.75), 0.01);
        assertEquals(26.12, CalculadoraIMC.calcularIMC(80D, 1.75), 0.01);
        assertEquals(31.02, CalculadoraIMC.calcularIMC(95D, 1.75), 0.01);
        assertEquals(35.92, CalculadoraIMC.calcularIMC(110D, 1.75), 0.01);
        assertEquals(39.18, CalculadoraIMC.calcularIMC(120D, 1.75), 0.01);
        assertEquals(42.45, CalculadoraIMC.calcularIMC(130D, 1.75), 0.01);
    }

    @Test
    public void testClassificacaoIMC() {
        assertEquals("Abaixo do peso", CalculadoraIMC.classificarIMC(16.33));
        assertEquals("Eutrófico", CalculadoraIMC.classificarIMC(22.86));
        assertEquals("Sobrepeso", CalculadoraIMC.classificarIMC(26.12));
        assertEquals("Obesidade grau I", CalculadoraIMC.classificarIMC(31.02));
        assertEquals("Obesidade grau II", CalculadoraIMC.classificarIMC(35.92));
        assertEquals("Obesidade grau III", CalculadoraIMC.classificarIMC(42.45));
    }

    @Test
    public void testValoresInvalidos() {
        
        //assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(-10, 1.75));
        //assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(70, -1.75));
        //assertThrows(IllegalArgumentException.class, () -> CalculadoraIMC.calcularIMC(0, 1.75));
    }
}
