import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculadoraIMCTest {
    
    @Test
    public void testCalcularIMC() {
        double resultado = CalculadoraIMC.calcularIMC(70, 1.75);
        assertEquals(22.86, resultado, 0.01);
    }
    
    @Test
    public void testClassificarIMC_AbaixoPeso() {
        String classificacao = CalculadoraIMC.classificarIMC(18.4);
        assertEquals("Abaixo do peso", classificacao);
    }
    
    @Test
    public void testClassificarIMC_PesoNormal() {
        String classificacao = CalculadoraIMC.classificarIMC(22.0);
        assertEquals("Peso normal", classificacao);
    }
    
    @Test
    public void testClassificarIMC_Sobrepeso() {
        String classificacao = CalculadoraIMC.classificarIMC(27.8);
        assertEquals("Sobrepeso", classificacao);
    }
    
    @Test
    public void testClassificarIMC_Obesidade() {
        String classificacao = CalculadoraIMC.classificarIMC(32.0);
        assertEquals("Obesidade", classificacao);
    }
}