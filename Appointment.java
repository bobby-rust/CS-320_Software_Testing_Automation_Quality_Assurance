import java.util.Date;

public class Appointment {
    private final String id;
    private Date date;
    private String description;

    /**
     * Instantiates an appointment with the given ID, date, and description.
     *
     * @param  id  the ID of the appointment
     * @param  date  the date of the appointment
     * @param  description  the description of the appointment
     * @throws IllegalArgumentException  if the ID is null or exceeds 10 characters
     * @throws IllegalArgumentException  if the description is null or exceeds 50 characters
     * @throws IllegalArgumentException  if the date is null or is in the past
     */
    Appointment(String id, Date date, String description) throws IllegalArgumentException {
        this.checkInstantiationArgs(id, description, date);
        this.id = id;
        this.description = description;
        this.date = date;
    }

    /**
     * Accessor for the appointment ID.
     *
     * @return the ID of this object
     */
    public String getID() {
        return id;
    }

    /**
     * Accessor for the appointment date.
     *
     * @return the date of this object
     */
    public Date getDate() {
        return date;
    }

    /**
     * Accessor for the appointment description.
     *
     * @return the description of this object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mutator for the appointment description.
     *
     * @param  description  the new description
     * @throws IllegalArgumentException  if the description is null or exceeds 50 characters
     */
    public void setDescription(String description) throws IllegalArgumentException {
        checkDescription(description);
        this.description = description;
    }

    /**
     * Mutator for the appointment date.
     *
     * @param  date  the new date
     * @throws IllegalArgumentException  if the date is null or is in the past
     */
    public void setDate(Date date) throws IllegalArgumentException {
        checkDate(date);
        this.date = date;
    }

    /**
     * Checks if the instantiation arguments are valid.
     *
     * @param  id  the ID of the appointment
     * @param  description  the description of the appointment
     * @param  date  the date of the appointment
     * @throws IllegalArgumentException  if the ID is null or exceeds 10 characters
     * @throws IllegalArgumentException  if the description is null or exceeds 50 characters
     * @throws IllegalArgumentException  if the date is null or is in the past
     */
    private void checkInstantiationArgs(String id, String description, Date date) throws IllegalArgumentException {
        checkID(id);
        checkDescription(description);
        checkDate(date);
    }

    /**
     * Ensures the ID is not null and does not exceed 10 characters.
     *
     * @param  id  the ID to be validated
     * @throws IllegalArgumentException  if the ID is null or exceeds 10 characters
     */
    private void checkID(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("ID must not be null.");
        if (id.length() > 10) throw new IllegalArgumentException("ID must be no more than 10 characters.");
    }

    /**
     * Ensures the description is not null and does not exceed 50 characters.
     *
     * @param  description  the description to be validated
     * @throws IllegalArgumentException  if the description is null or exceeds 50 characters
     */
    private void checkDescription(String description) throws IllegalArgumentException {
        if (description == null) throw new IllegalArgumentException("Description must not be null.");
        if (description.length() > 50) throw new IllegalArgumentException("Description must be no more than 50 characters.");
    }

    /**
     * Ensures the date is not null and is in the future.
     *
     * @param  date  the date to be validated
     * @throws IllegalArgumentException  if the date is null or is in the past
     */
    private void checkDate(Date date) throws IllegalArgumentException {
        if (date == null) throw new IllegalArgumentException("Date must not be null.");
        if (date.before(new Date())) {
            throw new IllegalArgumentException("Date must be in the future.");
        }
    }
}
