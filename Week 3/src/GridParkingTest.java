import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridParkingTest {

    @Test
    void findExistingCarCheck() {
        GridParking parkingLot = new GridParking("Some cool street", "Black");
        Car toyota = new Car("Blue", "toyota12");
        Car lambo = new Car("White", "gottagofast");
        parkingLot.parkCar(lambo);
        parkingLot.parkCar(toyota);
        assertTrue(parkingLot.findExistingCarCheck("toyota12"));
    }

    @Test
    void countCars() {
        GridParking parkingLot = new GridParking("Some cool street", "Black");
        Car toyota = new Car("Blue", "toyota12");
        Car lambo = new Car("White", "gottagofast");
        parkingLot.parkCar(lambo);
        parkingLot.parkCar(toyota);
        assertTrue(parkingLot.countCars());
    }

    @Test
    void checkAvailability() {
        GridParking parkingLot = new GridParking("Some cool street", "Black");
        Car toyota = new Car("Blue", "toyota12");
        Car lambo = new Car("White", "gottagofast");
        parkingLot.parkCar(lambo);
        parkingLot.parkCar(toyota);
        assertEquals("Occupied", parkingLot.checkAvailability(0,0));
    }
}