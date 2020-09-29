import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store jumbo = new Store("Jumbo");
    Regular_customer Jhon = new Regular_customer("Jhon", "California", 1);
    Regular_customer Mario = new Regular_customer("Mario", "California", 2);

    //Add a customer which is already inside the store
    @Test
    void testAddCustomerToStore() {
        jumbo.addCustomerToStore(Jhon);
        assertTrue(jumbo.existingCustomerCheck(Jhon));
        assertFalse(jumbo.existingCustomerCheck(Mario));
        assertEquals("The customer is already inside the store", jumbo.addCustomerToStore(Jhon));
    }

    //Check with multiple customer and with cities which are not found
    @Test
    void testGetCustomerFromCity() {
        ArrayList<Regular_customer> arrayList = new ArrayList<>();
        arrayList.add(Jhon);
        arrayList.add(Mario);
        jumbo.addCustomerToStore(Jhon);
        jumbo.addCustomerToStore(Mario);
        assertNull(jumbo.getCustomersFromCity("Orlando"));
        assertEquals(arrayList, jumbo.getCustomersFromCity("California"));
    }

    @Test
    void testRemoveCustomerByNumber() {
        ArrayList<Regular_customer> arrayList = new ArrayList<>();
        arrayList.add(Mario);
        jumbo.addCustomerToStore(Jhon);
        jumbo.addCustomerToStore(Mario);
        assertEquals("All customers with a customer number lower than 2 have been removed.", jumbo.removeCustomerByNumber(2));
        assertEquals("No customers with a customer number lower than -1 have been found.", jumbo.removeCustomerByNumber(-1));
        assertEquals(arrayList, jumbo.getCustomerList());
    }

    //Check if all customers get returned
    @Test
    void testGetAllCustomers() {
        ArrayList<Regular_customer> arrayList = new ArrayList<>();
        arrayList.add(Jhon);
        arrayList.add(Mario);
        jumbo.addCustomerToStore(Jhon);
        jumbo.addCustomerToStore(Mario);
        assertEquals(arrayList, jumbo.getCustomerList());
    }
}