public class Contact {
    private final String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    Contact(String id, String firstName, String lastName, String phone, String address) {
        checkID(id);
        this.id = id;

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
        this.setAddress(address);
    }

    // ID is not updatable and thus does not need a setter method
    public String getID() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        checkName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName){
        checkName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        checkPhone(phone);
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAddress(String address) {
        checkAddress(address);
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void checkID(String id) {
        if (id == null) throw new IllegalArgumentException("ID must not be null.");
        if (id.length() > 10) throw new IllegalArgumentException("ID must be no more than 10 characters.");
    }

    public void checkName(String name) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("Name must not be null.");
        if (name.length() > 10) throw new IllegalArgumentException("Name must be no more than 10 characters.");
    }

    public void checkAddress(String address) throws IllegalArgumentException {
        if (address == null) throw new IllegalArgumentException("Address must not be null.");
        if (address.length() > 30) throw new IllegalArgumentException("Address must be no more than 30 characters.");
    }

    public void checkPhone(String phone) throws IllegalArgumentException {
        if (phone == null) throw new IllegalArgumentException("Phone number must not be null.");
        if (phone.length() != 10) throw new IllegalArgumentException("Phone number must be exactly 10 characters.");
    }
}