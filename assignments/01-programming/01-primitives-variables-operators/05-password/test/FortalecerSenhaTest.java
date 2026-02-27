import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FortalecerSenhaTest {

    // @Test
    // public void testStringVazia() {
    //     String senhaFortalecida = FortalecerSenha.fortalecerSenha("");
    //     int tempoCalculado = FortalecerSenha.calcularTempoDigitacao(senhaFortalecida);
    //     assertEquals(4, tempoCalculado, "Uma senha vazia deve ter um tempo de digitação de 4 segundos após fortalecimento.");
    // }

    @ParameterizedTest
    @CsvSource({
        "'a', 4",
        "'z', 4",
        "'m', 4"
    })
    public void testUmCaracter(String input, int tempoEsperado) {
        String senhaFortalecida = FortalecerSenha.fortalecerSenha(input);
        int tempoCalculado = FortalecerSenha.calcularTempoDigitacao(senhaFortalecida);
        assertEquals(tempoEsperado, tempoCalculado, "O tempo deve ser maximizado corretamente.");
    }

    @ParameterizedTest
    @CsvSource({
        "'password', 18",
        "'java', 10",
        "'code', 10"
    })
    public void testFeliz(String input, int tempoEsperado) {
        String senhaFortalecida = FortalecerSenha.fortalecerSenha(input);
        int tempoCalculado = FortalecerSenha.calcularTempoDigitacao(senhaFortalecida);
        assertEquals(tempoEsperado, tempoCalculado, "O tempo deve ser maximizado corretamente.");
    }

    @ParameterizedTest
    @CsvSource({
        "'aaa', 7",
        "'bbbb', 8",
        "'cccccc', 10"
    })
    public void testCaracteresRepetidos(String input, int tempoEsperado) {
        String senhaFortalecida = FortalecerSenha.fortalecerSenha(input);
        int tempoCalculado = FortalecerSenha.calcularTempoDigitacao(senhaFortalecida);
        assertEquals(tempoEsperado, tempoCalculado, "A senha fortalecida deve ter o tempo correto.");
    }

    // @ParameterizedTest
    // @CsvSource({
    //     "'abc123', 12",
    //     "'pass@123', 16",
    //     "'hello!', 12"
    // })
    // public void testSenhaComNumerosSimbolos(String input, int tempoEsperado) {
    //     String senhaFortalecida = FortalecerSenha.fortalecerSenha(input);
    //     int tempoCalculado = FortalecerSenha.calcularTempoDigitacao(senhaFortalecida);
    //     assertEquals(tempoEsperado, tempoCalculado, "O tempo deve ser maximizado corretamente.");
    // }

    @Test
    public void testTamanhoMaximo() {
        String input = "abcdefghij"; // 10 caracteres
        String senhaFortalecida = FortalecerSenha.fortalecerSenha(input);
        int tempoCalculado = FortalecerSenha.calcularTempoDigitacao(senhaFortalecida);
        assertTrue(senhaFortalecida.length() == 11, "A senha fortalecida deve ter 11 caracteres.");
        assertTrue(tempoCalculado > FortalecerSenha.calcularTempoDigitacao(input),
                "A senha fortalecida deve aumentar o tempo de digitação.");
    }

    @Test
    public void testPerformance() {
        String longPassword = "a".repeat(10); // Senha com 10 caracteres

        assertTimeoutPreemptively(java.time.Duration.ofSeconds(1), () -> {
            FortalecerSenha.fortalecerSenha(longPassword);
        }, "O fortalecimento da senha deve ser rápido para senhas longas.");
    }

    @ParameterizedTest
    @CsvSource({
        "'a', 2",
        "'aa', 3",
        "'ab', 4",
        "'abc', 6",
        "'aba', 6",
        "'aaa', 4",
        "'abb', 5",
        "'abba', 7"
    })
    public void testCalculoTempoDigitacao(String senha, int tempoEsperado) {
        assertEquals(tempoEsperado, FortalecerSenha.calcularTempoDigitacao(senha),
                "O cálculo do tempo de digitação deve estar correto.");
    }
}
