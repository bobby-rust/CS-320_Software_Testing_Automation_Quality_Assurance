import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Uses values one over the valid limit for length tests to check for off-by-one errors
 */
public class ContactTest {
    @Test
    void testValidContact() {
        Contact c1 = new Contact("0123456789", "felixtheca", "topaztheca", "0123456789", "42 Wallaby Way, Sydney12345678");

        assertNotNull(c1);
        assertEquals("0123456789", c1.getID());
        assertEquals("felixtheca", c1.getFirstName());
        assertEquals("topaztheca", c1.getLastName());
        assertEquals("0123456789", c1.getPhone());
        assertEquals("42 Wallaby Way, Sydney12345678", c1.getAddress());
    }

    @Test
    void testContactNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "felixthecat", "r", "0123456789", "41 Catnip Drive"));

        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "felix", "likeslasaga", "0123456789", "41 Catnip Drive"));
    }


    @Test
    void testContactNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", null, "r", "0123456789", "41 Catnip Drive"));

        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Topaz", null, "0123456789", "41 Catnip Drive"));
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "topaz", "r", "01234567899", "41 Catnip Drive"));
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "topaz", "r", null, "41 Catnip Drive"));
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "topaz", "r", "0123456789", "Catnip Drive, Wallaby Way, Sydn"));
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "topaz", "r", "0123456789", null));
    }
}