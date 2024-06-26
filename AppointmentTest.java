import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentTest {

    /**
     * Tests the creation of an Appointment object with valid arguments.
     */
    @Test
    public void testAppointment() {
        Date date = new Date(new Date().getTime()  + java.time.Duration.ofDays(1).toMillis());
        Appointment appointment = new Appointment("ID 1", date, "Description 1");

        assertNotNull(appointment);
        assertEquals("ID 1", appointment.getID());
        assertEquals(date, appointment.getDate());
        assertEquals("Description 1", appointment.getDescription());
    }

    /**
     * Tests the creation of an Appointment object with a null ID.
     */
    @Test
    public void testAppointmentIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "Description 1");
        });
    }

    /**
     * Tests the creation of an Appointment object with an ID that exceeds 10 characters.
     */
    @Test
    public void testAppointmentIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(StringUtils.repeat("*", 11), new Date(), "Description 1");
        });
    }

    /**
     * Tests the creation of an Appointment object with a date in the past.
     */
    @Test
    public void testAppointmentDateInThePast() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("ID 1", new Date(0), "Description 1");
        });
    }

    /**
     * Tests the creation of an Appointment object with a null date.
     */
    @Test
    public void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("ID 1", null, "Description 1");
        });
    }

    /**
     * Tests the creation of an Appointment object with a null description.
     */
    @Test
    public void testAppointmentDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("ID 1", new Date(), null);
        });
    }

    /**
     * Tests the creation of an Appointment object with a description that exceeds 50 characters.
     */
    @Test
    public void testAppointmentDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("ID 1", new Date(), "Description 1".repeat(51));
        });
    }

    @Test
    void testUpdateDescription() {
        Appointment appointment = new Appointment("ID 1", new Date(), "Description 1");
        appointment.setDescription("Description 2");
        assertEquals("Description 2", appointment.getDescription());
    }

    @Test
    void testUpdateDate() {
        Date date = new Date(new Date().getTime()  + java.time.Duration.ofDays(1).toMillis());
        Appointment appointment = new Appointment("ID 1", date, "Description 1");

        Date date2 = new Date(new Date().getTime() + java.time.Duration.ofDays(2).toMillis());
        appointment.setDate(date2);
        assertEquals(date2, appointment.getDate());
    }
}
