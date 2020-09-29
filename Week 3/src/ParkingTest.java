import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    //I only tested the methods which actually return something as the rest only print out text

    @Test
    void countCars() {
        Parking parking = new Parking();
        Car tesla = new Car("Silver", "electricfunny");
        parking.parkCar(tesla);
        assertTrue(parking.countCars());
    }

    @Test
    void findExistingCarCheck() {
        Parking parking = new Parking();
        Car tesla = new Car("Silver", "electricfunny");
        parking.parkCar(tesla);
        assertTrue(parking.findExistingCarCheck("electricfunny"));
    }

    @Test
    void checkAvailability() {
        Parking parking = new Parking();
        Car tesla = new Car("Silver", "electricfunny");
        parking.parkCar(tesla);
        assertEquals("Free", parking.checkAvailability(17));
    }
}
