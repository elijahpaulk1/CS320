import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AppointmentServiceTest {
    @Test
    public void testAddAppointment() {
        // Test the addAppointment method in the AppointmentService class
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day from now

        assertTrue(appointmentService.getAppointments().isEmpty());

        appointmentService.addAppointment(new Appointment("A123456789", futureDate, "Meeting with client"));

        assertFalse(appointmentService.getAppointments().isEmpty());
        assertEquals(1, appointmentService.getAppointments().size());
        assertEquals("A123456789", appointmentService.getAppointments().get(0).getAppointmentID());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAppointment() {
        // Test adding an appointment with a duplicate ID
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day from now

        appointmentService.addAppointment(new Appointment("A123456789", futureDate, "Meeting with client"));
        appointmentService.addAppointment(new Appointment("A123456789", futureDate, "Another meeting")); // Should throw IllegalArgumentException
    }

    @Test
    public void testDeleteAppointment() {
        // Test the deleteAppointment method in the AppointmentService class
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day from now

        appointmentService.addAppointment(new Appointment("A123456789", futureDate, "Meeting with client"));
        assertFalse(appointmentService.getAppointments().isEmpty());

        appointmentService.deleteAppointment("A123456789");

        assertTrue(appointmentService.getAppointments().isEmpty());
    }
}
