import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.out.println("Setting up streams");
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.out.println("Restoring streams");
        System.setOut(originalOut);
    }

    @Test
    public void testMain() {
        HelloWorld.main(null);
        assertEquals("Hello, World!\n", outContent.toString());
    }

    @Test
    public void testConstructor() {
        HelloWorld h = new HelloWorld();
        System.out.println(h.toString());
        assertEquals(true, true);
    }

    @Test
    public void testWithParamer() {
        String[] args = {"a", "b"};
        HelloWorld.main(args);
        
        assertEquals("Hello, World!\n", outContent.toString());
    }

}
