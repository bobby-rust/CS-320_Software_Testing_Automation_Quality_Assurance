import java.util.HashMap;

public class AppointmentService {
    HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();

    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getID())) {
            throw new IllegalArgumentException(String.format("Appointment with ID %s already exists.", appointment.getID()));
        }

        appointments.put(appointment.getID(), appointment);
    }

    public void deleteAppointment(String id) throws IllegalArgumentException {
        if (!appointments.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Appointment with ID %s does not exist.", id));
        }

        appointments.remove(id);
    }
}
