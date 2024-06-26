import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    /**
     * Tests the creation of an AppointmentService object.
     */
    @Test
    void testAppointmentService() {
        AppointmentService appointmentService = new AppointmentService();
        assertNotNull(appointmentService);
        assertNotNull(appointmentService.appointments);
        assertTrue(appointmentService.appointments.isEmpty());
    }

    /**
     * Tests the addition of an Appointment object.
     */
    @Test void testAddAppointment() {
        AppointmentService appointmentService = new AppointmentService();

        Appointment appointment = new Appointment("ID 1", new Date(new Date().getTime() + java.time.Duration.ofDays(1).toMillis()), "Description 1");
        appointmentService.addAppointment(appointment);
        assertTrue(appointmentService.appointments.containsKey(appointment.getID()));

        // Test add invalid appointment, ID exists
        Appointment appointment2 = new Appointment("ID 1", new Date(new Date().getTime() + java.time.Duration.ofDays(1).toMillis()), "Description 1");
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    /**
     * Tests the deletion of an Appointment object.
     */
    @Test void testDeleteAppointment() {
        AppointmentService appointmentService = new AppointmentService();

        Appointment appointment = new Appointment("ID 1", new Date(new Date().getTime() + java.time.Duration.ofDays(1).toMillis()), "Description 1");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment(appointment.getID());
        assertTrue(appointmentService.appointments.isEmpty());

        // Test delete invalid appointment, ID does not exist
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("ID 2");
        });
    }
}
