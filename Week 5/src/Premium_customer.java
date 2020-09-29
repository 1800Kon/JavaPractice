public class Premium_customer extends Regular_customer {
    private int discount;

    public Premium_customer(String name, String city, int number, int discount) {
        //Super is used to make it so it copies the constructor of the top class you're extending off of
        super(name, city, number);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
