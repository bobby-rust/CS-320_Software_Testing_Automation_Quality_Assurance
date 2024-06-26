import java.util.HashSet;

public class Task {
    private final String id;
    private String name;
    private String description;

    /**
     * Constructor for the TaskService class.
     * Creates a new TaskService object with the given ID, name, and description.
     *
     * @param  id the ID of the task
     * @param  name  the name of the task
     * @param  description  the description of the task
     * @throws IllegalArgumentException  if the ID is null or exceeds 10 characters
     * @throws IllegalArgumentException  if the name is null or exceeds 20 characters
     * @throws IllegalArgumentException  if the description is null or exceeds 50 characters
     */
    public Task(String id, String name, String description) {
        checkInstantiationArgs(id, name, description);
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Accessor for the ID field.
     *
     * @return the ID of this object
     */
    public String getID() {
        return this.id;
    }

    /**
     * Accessor for the name field.
     *
     * @return the name of this object
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mutator for the name field.
     *
     * @param  name  the new name
     * @throws IllegalArgumentException  if the name is null or exceeds 20 characters
     */
    public void setName(String name) {
        checkName(name);
        this.name = name;
    }

    /**
     * Accessor for the description field.
     *
     * @return the description of this object
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Mutator for the description field.
     *
     * @param  description  the new description
     * @throws IllegalArgumentException  if the description is null or exceeds 50 characters
     */
    public void setDescription(String description) {
        checkDescription(description);
        this.description = description;
    }

    /**
     * Checks if the instantiation arguments are valid.
     *
     * @param  id the ID of the task
     * @param  name  the name of the task
     * @param  description  the description of the task
     * @throws IllegalArgumentException  if the ID is null or exceeds 10 characters
     * @throws IllegalArgumentException  if the name is null or exceeds 20 characters
     * @throws IllegalArgumentException  if the description is null or exceeds 50 characters
     */
    private void checkInstantiationArgs(String id, String name, String description) {
        checkID(id);
        checkName(name);
        checkDescription(description);
    }

    /**
     * Ensures the ID is not null and does not exceed 10 characters.
     *
     * @param  id  the ID to be validated
     * @throws IllegalArgumentException  if the ID is null or exceeds 10 characters
     */
    private void checkID(String id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }

        if (id.length() > 10) {
            throw new IllegalArgumentException("ID must be no longer than 10 characters.");
        }
    }

    /**
     * Ensures the name is not null and does not exceed 20 characters.
     *
     * @param  name  the name to be validated
     * @throws IllegalArgumentException  if the name is null or exceeds 20 characters
     */
    private void checkName(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }

        if (name.length() > 20) {
            throw new IllegalArgumentException("Name must be no longer than 20 characters.");
        }
    }

    /**
     * Ensures the description is not null and does not exceed 50 characters.
     *
     * @param  description  the description to be validated
     * @throws IllegalArgumentException  if the description is null or exceeds 50 characters
     */
    private void checkDescription(String description) throws IllegalArgumentException {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        }

        if (description.length() > 50) {
            throw new IllegalArgumentException("Description must be no longer than 50 characters.");
        }
    }
}
