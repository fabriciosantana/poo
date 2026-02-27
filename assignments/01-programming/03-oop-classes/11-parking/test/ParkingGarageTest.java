import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingGarageTest {

    @Test
    public void testMinimumChargeForUpTo3Hours() {
        assertEquals(2.00, ParkingGarage.calculateCharges(1.0), 0.01);
        assertEquals(2.00, ParkingGarage.calculateCharges(2.5), 0.01);
        assertEquals(2.00, ParkingGarage.calculateCharges(3.0), 0.01);
    }

    @Test
    public void testAdditionalChargeForMoreThan3Hours() {
        assertEquals(2.50, ParkingGarage.calculateCharges(3.5), 0.01);
        assertEquals(2.50, ParkingGarage.calculateCharges(4.0), 0.01);
        assertEquals(3.00, ParkingGarage.calculateCharges(5.0), 0.01);
        assertEquals(5.00, ParkingGarage.calculateCharges(9.0), 0.01);
    }

    @Test
    public void testMaximumChargeFor24Hours() {
        assertEquals(10.00, ParkingGarage.calculateCharges(24.0), 0.01);
        assertEquals(8.00, ParkingGarage.calculateCharges(15.0), 0.01);
    }

    @Test
    public void testRoundingUpForPartialHours() {
        assertEquals(3.00, ParkingGarage.calculateCharges(4.1), 0.01);
        assertEquals(3.50, ParkingGarage.calculateCharges(5.4), 0.01);
        assertEquals(4.00, ParkingGarage.calculateCharges(6.9), 0.01);
    }
    
    @Test
    public void testInvalidValues() {
        assertEquals(2.00, ParkingGarage.calculateCharges(0.0), 0.01); // Assume taxa mínima para 0h
        assertEquals(10.00, ParkingGarage.calculateCharges(25.0), 0.01); // Assume taxa máxima para > 24h
    }
}
