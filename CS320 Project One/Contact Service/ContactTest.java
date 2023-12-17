import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactIDNull() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactIDTooLong() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstNameNull() {
        new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstNameTooLong() {
        new Contact("1234567890", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
    }

}
