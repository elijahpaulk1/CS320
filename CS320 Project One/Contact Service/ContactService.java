import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        // Check if a contact with the same ID already exists
        if (getContactByID(contact.getContactID()) != null) {
            throw new IllegalArgumentException("Contact with the same ID already exists.");
        }

        contacts.add(contact);
    }

    public void deleteContact(String contactID) {
        Contact contact = getContactByID(contactID);
        if (contact != null) {
            contacts.remove(contact);
        }
    }

    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = getContactByID(contactID);
        if (contact != null) {
            // Update the contact's fields
            if (firstName != null) {
                contact.setFirstName(firstName);
            }
            if (lastName != null) {
                contact.setLastName(lastName);
            }
            if (phone != null) {
                contact.setPhone(phone);
            }
            if (address != null) {
                contact.setAddress(address);
            }
        }
    }    

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public Contact getContactByID(String contactID) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return null; // Contact not found
    }
}
