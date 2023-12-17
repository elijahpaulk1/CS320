import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments;

    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        if (isAppointmentIDUnique(appointment.getAppointmentID())) {
            appointments.add(appointment);
        } else {
            throw new IllegalArgumentException("Appointment ID must be unique.");
        }
    }

    public void deleteAppointment(String appointmentID) {
        appointments.removeIf(appointment -> appointment.getAppointmentID().equals(appointmentID));
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }


    private boolean isAppointmentIDUnique(String appointmentID) {
        return appointments.stream().noneMatch(appointment -> appointment.getAppointmentID().equals(appointmentID));
    }

    // Main method for testing the AppointmentService functionality
    public static void main(String[] args) {
        // Instantiate AppointmentService and perform operations
        AppointmentService appointmentService = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day from now

        // Example: Add an appointment
        appointmentService.addAppointment(new Appointment("A123456789", futureDate, "Meeting with client"));

        // Example: Display appointments
        System.out.println("Appointments:");
        for (Appointment appointment : appointmentService.getAppointments()) {
            System.out.println(appointment);
        }

        // Example: Delete an appointment
        appointmentService.deleteAppointment("A123456789");

        // Example: Display appointments after deletion
        System.out.println("Appointments after deletion:");
        for (Appointment appointment : appointmentService.getAppointments()) {
            System.out.println(appointment);
        }
    }
}
