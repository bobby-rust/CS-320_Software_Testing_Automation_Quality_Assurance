import java.util.HashMap;

public class ContactService {
    // Key here is the contact id, use hashmap for constant time lookup by id
    HashMap<String, Contact> contacts = new HashMap<String, Contact>();
    public void addContact(Contact contact) throws IllegalArgumentException {
        if (idExists(contact.getID())) throw new IllegalArgumentException(String.format("Contact with ID %s already exists.", contact.getID()));
        contacts.put(contact.getID(), contact);
    }

    public void deleteContact(String id) throws IllegalArgumentException {
        if (!idExists(id))  throw new IllegalArgumentException(String.format("Contact with ID %s does not exist.", id));
        contacts.remove(id);
    }

    public void updateFirstName(String id, String firstName) throws IllegalArgumentException {
        if (!idExists(id)) {
            throw new IllegalArgumentException("ID does not exist.");
        }

        Contact contact = contacts.get(id);
        contact.setFirstName(firstName);
    }

    public void updateLastName(String id, String lastName) throws IllegalArgumentException {
        if (!idExists(id)) {
            throw new IllegalArgumentException("ID does not exist.");
        }

        Contact contact = contacts.get(id);
        contact.setLastName(lastName);
    }

    public void updatePhone(String id, String phone) throws IllegalArgumentException {
        if (!idExists(id)) {
            throw new IllegalArgumentException("ID does not exist.");
        }

        Contact contact = contacts.get(id);
        contact.setPhone(phone);
    }

    public void updateAddress(String id, String address) throws IllegalArgumentException {
        if (!idExists(id)) {
            throw new IllegalArgumentException("ID does not exist.");
        }

        Contact contact = contacts.get(id);
        contact.setAddress(address);
    }

    private boolean idExists(String id) {
        return contacts.get(id) != null;
    }
}
