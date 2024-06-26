import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactServiceTest {
    @Test
    void testContactService() {
        // Test initialization
        ContactService cs = new ContactService();
        assertNotNull(cs.contacts);
        assertTrue(cs.contacts.isEmpty());
    }

    @Test
    void testAddContact() {
        ContactService cs = new ContactService();
        // Test adding valid contact
        Contact c1 = new Contact("1", "bob", "r", "0123456789", "42 Wallaby Way, Sydney");
        cs.addContact(c1);
        assertEquals(1, cs.contacts.size());

        // Test add invalid contact, ID exists
        Contact c2 = new Contact("1", "felix", "r", "0123456789", "New York City");
        assertThrows(IllegalArgumentException.class, () -> {
            cs.addContact(c2);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService cs = new ContactService();

        Contact c1 = new Contact("1", "topaz", "jones", "0123456789", "51 Catnip Drive");
        cs.addContact(c1);

        // Test deleting valid contact
        cs.deleteContact(c1.getID());
        assertTrue(cs.contacts.isEmpty());

        // Test delete invalid contact, ID does not exist
        cs.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> {
            cs.deleteContact("2");
        });
    }

    @Test
    void testUpdateContactName() {
        ContactService cs = new ContactService();
        Contact c1 = new Contact("1", "topaz", "jones", "0123456789", "51 Catnip Drive");
        cs.addContact(c1);

        // Test update valid contact first name
        cs.updateFirstName("1", "felix");
        assertEquals("felix", c1.getFirstName());

        // Test update invalid contact first name, ID does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            cs.updateFirstName("2", "topaz");
        });

        // Test update valid contact last name
        cs.updateLastName("1", "r");
        assertEquals("r", c1.getLastName());

        // Test update invalid contact last name, ID does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            cs.updateLastName("2", "r");
        });
    }

    @Test
    void testUpdateContactPhone() {
        ContactService cs = new ContactService();
        Contact c1 = new Contact("1", "topaz", "jones", "0123456789", "51 Catnip Drive");
        cs.addContact(c1);

        // test update valid contact phone
        cs.updatePhone("1", "9876543210");
        assertEquals("9876543210", c1.getPhone());

        // test update invalid contact phone, ID does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            cs.updatePhone("2", "9876543210");
        });
    }

    @Test
    void testUpdateContactAddress() {
        ContactService cs = new ContactService();
        Contact c1 = new Contact("1", "topaz", "jones", "0123456789", "51 Catnip Drive");
        cs.addContact(c1);

        // test update valid contact phone
        cs.updateAddress("1", "56 Bug Forest");
        assertEquals("56 Bug Forest", c1.getAddress());

        // test update invalid contact phone, ID does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            cs.updateAddress("2", "56 Bug Forest");
        });
    }
}