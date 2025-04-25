import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TruckTest {

    @Test
    public void testCalculateParkingFee() {
        Truck truck = new Truck("TRK1234", "Volvo", "FH16");

        assertEquals(0.0, truck.calculateParkingFee(0), 0.01);
        assertEquals(10.0, truck.calculateParkingFee(1), 0.01);
        assertEquals(40.0, truck.calculateParkingFee(4), 0.01);
        assertEquals(100.0, truck.calculateParkingFee(10), 0.01);
        assertEquals(1000.0, truck.calculateParkingFee(100), 0.01);
    }

    @Test
    public void testToString() {
        Truck truck = new Truck("TRK5678", "Mercedes", "Actros");

        assertEquals("Caminhão - Placa: TRK5678 - Marca: Mercedes - Modelo: Actros", truck.toString());
    }

    @Test
    public void testConstructorAndGetters() {
        Truck truck = new Truck("TRK9012", "Scania", "R500");

        assertEquals("TRK9012", truck.getPlate());
        assertEquals("Scania", truck.getBrand());
        assertEquals("R500", truck.getModel());
    }
}
