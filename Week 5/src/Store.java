import java.util.ArrayList;

public class Store {
    private String storeName;
    private final ArrayList<Regular_customer> customers;

    public Store(String storeName) {
        this.storeName = storeName;
        this.customers = new ArrayList<>();
    }

    /**
     * Adds a customer to the store
     *
     * @param customer Customer to be added
     * @return Returns if the customer was added successfully or not
     */
    public String addCustomerToStore(Regular_customer customer) {
        if (!existingCustomerCheck(customer)) {
            customers.add(customer);
            return "The customer was added successfully";
        } else {
            return "The customer is already inside the store";
        }
    }

    /**
     * Checks if a customer is already inside the store
     *
     * @param customer The customer to be searched for
     * @return True if the customer is already inside the store
     */
    public boolean existingCustomerCheck(Regular_customer customer) {
        return customers.contains(customer);
    }

    /**
     * Returns all customers from a certain city
     *
     * @param city The city to be looked for
     * @return ArrayList with all the customers or null
     */
    public ArrayList<Regular_customer> getCustomersFromCity(String city) {
        ArrayList<Regular_customer> arrayList = new ArrayList<>();
        int counter = 0;
        for (Regular_customer customer : customers) {
            if (customer.getCity().equals(city)) {
                arrayList.add(customer);
                counter++;
            }
        }
        if (counter == 0) {
            return null;
        } else {
            return arrayList;
        }
    }

    /**
     * Prints all the customers from a city
     *
     * @param city City
     */
    public void printAllCustomersFromACity(String city) {
        for (Regular_customer customer : getCustomersFromCity(city)
        ) {
            System.out.println(customer.getName());
        }
    }

    /**
     * Removes customers from the store with a customer number smaller than the one specified
     *
     * @param customerNo The customer number to be looked for
     * @return Returns if any customers have been returned or not
     */
    public String removeCustomerByNumber(int customerNo) {
        int counter = 0;
        if (customers.removeIf(customer -> customer.getNumber() < customerNo)) {
            counter++;
        }
        if (counter > 0) {
            return "All customers with a customer number lower than " + customerNo + " have been removed.";
        } else {
            return "No customers with a customer number lower than " + customerNo + " have been found.";
        }
    }

    /**
     * @return Returns all customers
     */
    public ArrayList<Regular_customer> getCustomerList() {
        return this.customers;
    }

    /**
     * Prints all the customers in the store
     */
    public void printAllCustomers() {
        for (Regular_customer customer : customers) {
            System.out.println(customer.getName());
        }
    }
}
