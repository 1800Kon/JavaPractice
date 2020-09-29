public class Main {
    public static void main(String[] args) {
        Store jumbo = new Store("Jumbo");
        Regular_customer Jhon = new Regular_customer("Jhon", "California", 1);
        Regular_customer Mario = new Regular_customer("Mario", "Florida", 2);
        Premium_customer Luigi = new Premium_customer("Luigi", "Boston", 3, 15);
        Premium_customer Wario = new Premium_customer("Wario", "Florida", 4, 10);
        System.out.println(jumbo.addCustomerToStore(Jhon));
        System.out.println(jumbo.addCustomerToStore(Mario));
        System.out.println(jumbo.addCustomerToStore(Luigi));
        System.out.println(jumbo.addCustomerToStore(Wario));
        jumbo.printAllCustomersFromACity("Florida");
        System.out.println(jumbo.removeCustomerByNumber(2));
        System.out.println(Mario.getCustomerCode());
        Regular_customer.setPrefix("Test");
        System.out.println(Mario.getCustomerCode());
    }
}
