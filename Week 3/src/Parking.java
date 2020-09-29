//Konstantin Stilian Boguev 4669886
public class Parking {
    private static final int slots = 22;
    private Car[] parkingSlots;

    public Parking() {
        parkingSlots = new Car[slots];
    }

    /**
     * In here you can find a test for all outcomes possible for the methods, I dont think I missed any.
     */
    public static void main(String[] args) {
        //Making new instance of parking and creating cars.
        Parking parking = new Parking();
        Car tesla = new Car("Silver", "electricfunny");
        Car honda = new Car("Black", "hondabrrr");
        Car bmw = new Car("Yellow", "hahacar");
        //Parking cars.
        parking.parkCar(bmw);
        parking.parkCar(tesla);
        parking.parkCar(honda);
        parking.parkCar(bmw);
        //Trying to remove a car which is not inside the parking.
        parking.removeCar("notfound");
        //Removing a car which is inside the parking.
        parking.removeCar("hondabrrr");
        //Making a new parking lot and creating cars.
        GridParking parkingLot = new GridParking("Some cool street", "Black");
        Car toyota = new Car("Blue", "toyota12");
        Car lambo = new Car("White", "gottagofast");
        parkingLot.parkCar(lambo);
        parkingLot.parkCar(toyota);
        parkingLot.parkCar(lambo);
        //Trying to remove a car which doesnt exist inside the parking lot.
        parkingLot.removeCar("notfound");
        //Removing a car which does exist inside the parking lot.
        parkingLot.removeCar("gottagofast");
        //Checking the availability of spaces between the array boundaries.
        System.out.println(parking.checkAvailability(1));
        System.out.println(parkingLot.checkAvailability(1, 1));
        //Checking the availability of spaces outside the array boundaries.
        System.out.println(parking.checkAvailability(222));
        System.out.println(parkingLot.checkAvailability(111, 111));
        System.out.println(parkingLot.checkAvailability(0, 0));
    }

    /**
     * Method to park a car inside the parking space, it checks if there is space inside the parking and if the car is already inside of the parking.
     *
     * @param car The car to be added to the parking, the license plate it has must be unique otherwise it wont be added to the parking.
     */
    public void parkCar(Car car) {
        if (countCars() == true) {
            if (!findExistingCarCheck(car.getLicensePlate())) {
                for (int i = 0; i < parkingSlots.length; i++) {
                    if (parkingSlots[i] == null) {
                        parkingSlots[i] = car;
                        System.out.println("The following car has been parked in parking #" + i + ": " + car.getLicensePlate());
                        break;
                    }
                }
            } else {
                System.out.println("A car with the same exact license plate is already parked, the new car has not been added.");
            }
        } else {
            System.out.println("The parking is currently full, please remove one of the cars.");
        }
    }

    /**
     * Method to count all the cars currently parked inside the parking to determine if another car can be parked inside.
     *
     * @return True or false depending on if the parking is full or not.
     */
    public boolean countCars() {
        int p = 0;
        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] != null) {
                p++;
            }
        }
        return p < slots;
    }

    /**
     * Method to check if a car with the same license plate is already inside the parking.
     *
     * @param licensePlate The license plate to be searched for inside the parking.
     * @return True or false depending on if the car is found inside of the parking.
     */
    public boolean findExistingCarCheck(String licensePlate) {
        int p = 0;
        for (Car parkingSlot : parkingSlots) {
            if (parkingSlot != null) {
                if (parkingSlot.getLicensePlate().equals(licensePlate)) {
                    p++;
                }
            }
        }
        return p > 0;
    }

    /**
     * Method to remove a car from a parking space. It checks if a car with said license plate is inside the parking and then removes it.
     *
     * @param licensePlate The license plate to be looked for inside the parking.
     */
    public void removeCar(String licensePlate) {
        boolean check = false;
        for (int i = 0; i < slots; i++) {
            if (parkingSlots[i] != null) {
                if (parkingSlots[i].getLicensePlate().equals(licensePlate)) {
                    parkingSlots[i] = null;
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            System.out.println("The car with license plate " + licensePlate + " has been removed.");
        } else {
            System.out.println("We could not find a car with license plate #" + licensePlate + ".");
        }
    }

    /**
     * Method to check if a certain parking space is available inside the parking.
     *
     * @param space Int used to specify which array entry the method will look in, it represents the parking number.
     * @return Returns "Free" if the space has no car assigned to it, else it returns "Occupied".
     */
    public String checkAvailability(int space) {
        String result = "The parking space you entered doesn't exist.";
        if ((space <= slots)) {
            result = this.parkingSlots[space] == null ? "Free" : "Occupied";
        }
        return result;
    }

}
