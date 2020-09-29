//Konstantin Stilian Boguev 4669886
public class GridParking {
    private String address;
    private String color;
    private static final int after = 23;
    private static final int next = 22;
    private Car[][] parkingLot;

    public GridParking(String address, String color) {
        this.address = address;
        this.color = color;
        parkingLot = new Car[after][next];
    }

    /**
     * Method to park a car inside the parking space, it checks if there is space inside the parking and if the car is already inside of the parking.
     *
     * @param car The car to be added to the parking, the license plate it has must be unique otherwise it wont be added to the parking.
     */
    public void parkCar(Car car) {
        if (countCars()) {
            if (!findExistingCarCheck(car.getLicensePlate())) {
                //The outer: label is used to break out of the nested loop once the car is added.
                outer:
                for (int i = 0; i < parkingLot.length; i++) {
                    for (int p = 0; p < parkingLot[i].length; p++) {
                        if (parkingLot[i][p] == null) {
                            parkingLot[i][p] = car;
                            System.out.println("The car with the license plate #" + car.getLicensePlate() + " has been parked in column " + i + " row " + p + ".");
                            break outer;
                        }
                    }
                }
            } else {
                System.out.println("The car is already parked inside.");
            }
        } else {
            System.out.println("The parking is currently full, please remove a car and try again.");
        }
    }

    /**
     * Method to check if a car with the same license plate is already inside the parking.
     *
     * @param licensePlate The license plate to be searched for inside the parking.
     * @return True or false depending on if the car is found inside of the parking.
     */
    public boolean findExistingCarCheck(String licensePlate) {
        int x = 0;
        for (int i = 0; i < parkingLot.length; i++) {
            for (int p = 0; p < parkingLot[i].length; p++) {
                if (parkingLot[i][p] != null) {
                    if (parkingLot[i][p].getLicensePlate().equals(licensePlate)) {
                        x++;
                        break;
                    }
                }
            }
        }
        return x > 0;
    }

    /**
     * Method to count all the cars currently parked inside the parking to determine if another car can be parked inside.
     *
     * @return True or false depending on if the parking is full or not.
     */
    public boolean countCars() {
        int check = 0;
        for (int i = 0; i < parkingLot.length; i++) {
            for (int p = 0; p < parkingLot[i].length; p++) {
                if (parkingLot[i][p] != null) {
                    check++;
                }
            }
        }
        return check < 552;
    }

    /**
     * Method to remove a car from a parking space. It checks if a car with said license plate is inside the parking and then removes it.
     *
     * @param licensePlate The license plate to be looked for inside the parking.
     */
    public void removeCar(String licensePlate) {
        boolean check = false;
        for (int i = 0; i < parkingLot.length; i++) {
            for (int p = 0; p < parkingLot[i].length; p++) {
                if (parkingLot[i][p] != null) {
                    if (parkingLot[i][p].getLicensePlate().equals(licensePlate)) {
                        check = true;
                        parkingLot[i][p] = null;
                        break;
                    }
                }
            }
        }
        if (check) {
            System.out.println("The car with the license plate #" + licensePlate + " has been removed.");
        } else {
            System.out.println("The car with the license plate #" + licensePlate + " could not be found inside the parking.");
        }
    }

    /**
     * Method to check if a certain parking space is available inside the parking.
     *
     * @param column Int representing the Y axis inside the 2d array.
     * @param row    Int representing the X axis inside the 2d array.
     * @return Returns "Free" if the space has no car assigned to it, else it returns "Occupied".
     */
    public String checkAvailability(int column, int row) {
        String result = "The parking space you entered doesn't exist.";
        if ((column <= next & row <= after)) {
            result = parkingLot[column][row] == null ? "Free" : "Occupied";
        }
        return result;
    }
}
