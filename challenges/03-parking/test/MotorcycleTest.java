import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotorcycleTest {

    @Test
    public void testCalculateParkingFee() {
        Motorcycle motorcycle = new Motorcycle("XYZ1234", "Yamaha", "R3");

        assertEquals(0.0, motorcycle.calculateParkingFee(0), 0.01);
        assertEquals(3.0, motorcycle.calculateParkingFee(1), 0.01);
        assertEquals(12.0, motorcycle.calculateParkingFee(4), 0.01);
        assertEquals(30.0, motorcycle.calculateParkingFee(10), 0.01);
        assertEquals(300.0, motorcycle.calculateParkingFee(100), 0.01);
    }

    @Test
    public void testToString() {
        Motorcycle motorcycle = new Motorcycle("LMN5678", "Honda", "CB500");

        assertEquals("Moto - Placa: LMN5678 - Marca: Honda - Modelo: CB500", motorcycle.toString());
    }

    @Test
    public void testConstructorAndGetters() {
        Motorcycle motorcycle = new Motorcycle("OPQ9012", "Suzuki", "GSX-R750");

        assertEquals("OPQ9012", motorcycle.getPlate());
        assertEquals("Suzuki", motorcycle.getBrand());
        assertEquals("GSX-R750", motorcycle.getModel());
    }
}
