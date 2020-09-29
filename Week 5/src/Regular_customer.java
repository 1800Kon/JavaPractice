public class Regular_customer {
    private String name;
    private String city;
    private int number;
    //Static makes it have the same value for all instances of the class
    private static String prefix = "MM_";

    public Regular_customer(String name, String city, int number) {
        this.name = name;
        this.city = city;
        this.number = number;
    }

    /**
     * Gets the customer code
     *
     * @return Customer code in String form
     */
    public String getCustomerCode() {
        return getPrefix() + this.getNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        Regular_customer.prefix = prefix + "_";
    }

}
