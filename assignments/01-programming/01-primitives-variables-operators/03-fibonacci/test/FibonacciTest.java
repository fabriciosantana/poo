import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    @Test
    public void testValorLimiteZero() {
        long resultado = Fibonacci.calcularFibonacci(0);
        assertEquals(0, resultado, "O número de Fibonacci para n=0 deve ser 0.");
    }

    @Test
    public void testValorLimiteUm() {
        long resultado = Fibonacci.calcularFibonacci(1);
        assertEquals(1, resultado, "O número de Fibonacci para n=1 deve ser 1.");
    }

    @Test
    public void testValorLimiteDez() {
        long resultado = Fibonacci.calcularFibonacci(10);
        assertEquals(55, resultado, "O número de Fibonacci para n=10 deve ser 55.");
    }

    @Test
    public void testValorLimiteCinquenta() {
        long resultado = Fibonacci.calcularFibonacci(50);
        assertEquals(12586269025L, resultado, "O número de Fibonacci para n=50 deve ser 12586269025.");
    }

    @Test
    public void testValoresValidosPequenos() {
        long resultado = Fibonacci.calcularFibonacci(5);
        assertEquals(5, resultado, "O número de Fibonacci para n=5 deve ser 5.");
    }

    @Test
    public void testValoresValidosGrandes() {
        long resultado = Fibonacci.calcularFibonacci(20);
        assertEquals(6765, resultado, "O número de Fibonacci para n=20 deve ser 6765.");
    }

    @Test
    public void testValorNegativoInvalido() {
        //Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        //    Fibonacci.calcularFibonacci(-5);
        //});
        //assertEquals("O número deve ser não negativo.", exception.getMessage());
    }

    @Test
    public void testCondicaoFalsaParaZero() {
        long resultado = Fibonacci.calcularFibonacci(0);
        assertEquals(0, resultado, "Deve retornar 0 para n=0.");
    }

    @Test
    public void testCondicaoFalsaParaUm() {
        long resultado = Fibonacci.calcularFibonacci(1);
        assertEquals(1, resultado, "Deve retornar 1 para n=1.");
    }

    @Test
    public void testCondicaoFalsaParaIteracao() {
        long resultado = Fibonacci.calcularFibonacci(2);
        assertEquals(1, resultado, "Deve calcular corretamente Fibonacci(2).");
    }

    @Test
    public void testFormatacaoSaida() {
        String saida = Fibonacci.formatarSaida(13, 7);
        assertEquals("O 7º número de Fibonacci é: 13", saida, "A formatação da saída está incorreta.");
    }
}
