import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneTest {

    @Test
    void deveLancarExcecaoQuandoNomeVazio() {
        ValidationException ex = assertThrows(
            ValidationException.class,
            () -> new Phone("", "1234567890123456")
        );
        assertEquals("O nome do telefone não pode estar vazio.", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoSerialInvalido() {
        ValidationException ex = assertThrows(
            ValidationException.class,
            () -> new Phone("Motorola", "12345")
        );
        assertEquals("O número de série deve conter exatamente 16 dígitos.", ex.getMessage());
    }

    @Test
    void deveCriarPhoneComDadosValidos() {
        assertDoesNotThrow(() -> {
            Phone phone = new Phone("Nokia", "1234567890123456");
            assertEquals("Nokia", phone.getName());
            assertEquals("1234567890123456", phone.getSerialNumber());
        });
    }
}
