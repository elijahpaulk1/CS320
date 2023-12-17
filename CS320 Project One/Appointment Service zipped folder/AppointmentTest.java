import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AppointmentTest {
    @Test
    public void testAppointmentConstructor() {
        // Test the constructor of the Appointment class
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day from now

        Appointment appointment = new Appointment("A123456789", futureDate, "Meeting with client");

        assertEquals("A123456789", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Meeting with client", appointment.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentConstructor() {
        // Test the constructor with invalid arguments
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day ago

        new Appointment(null, new Date(), "Invalid"); // Should throw IllegalArgumentException
        new Appointment("TooLongAppointmentID", new Date(), "Invalid"); // Should throw IllegalArgumentException
        new Appointment("A123456789", pastDate, "Invalid"); // Should throw IllegalArgumentException
        new Appointment("A123456789", new Date(), null); // Should throw IllegalArgumentException
        new Appointment("A123456789", new Date(), "This description is too long and should cause an exception"); // Should throw IllegalArgumentException
    }

}
