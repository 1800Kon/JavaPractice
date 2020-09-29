//Konstantin Stilian Boguev 4669886
public class Car {
    private String color;
    private String LicensePlate;

    public Car(String color, String licensePlate) {
        this.color = color;
        this.LicensePlate = licensePlate;
    }

    /**
     * Method to get the license plate of the car.
     *
     * @return License plate.
     */
    public String getLicensePlate() {
        return this.LicensePlate;
    }
}
