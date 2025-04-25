import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCalculateParkingFee() {
        Car car = new Car("ABC1234", "Toyota", "Corolla");

        assertEquals(0.0, car.calculateParkingFee(0), 0.01);
        assertEquals(5.0, car.calculateParkingFee(1), 0.01);
        assertEquals(20.0, car.calculateParkingFee(4), 0.01);
        assertEquals(50.0, car.calculateParkingFee(10), 0.01);
        assertEquals(500.0, car.calculateParkingFee(100), 0.01);
    }

    @Test
    public void testToString() {
        Car car = new Car("DEF5678", "Honda", "Civic");

        assertEquals("Carro - Placa: DEF5678 - Marca: Honda - Modelo: Civic", car.toString());
    }

    @Test
    public void testConstructorAndGetters() {
        Car car = new Car("GHI9012", "Ford", "Focus");

        assertEquals("GHI9012", car.getPlate());
        assertEquals("Ford", car.getBrand());
        assertEquals("Focus", car.getModel());
    }
}


