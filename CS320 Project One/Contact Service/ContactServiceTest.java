import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @Before
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertEquals(1, contactService.getAllContacts().size());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertEquals(0, contactService.getAllContacts().size());
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        
        // Update the first name
        contactService.updateContact("1234567890", "Jane", null, null, null);
        Contact updatedContact = contactService.getContactByID("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContactID() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "9876543210", "456 Elm St");
        
        contactService.addContact(contact1);
        contactService.addContact(contact2);
    }

}
