import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
    private String appointmentID;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        // Check and set appointment ID
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must not be null and cannot be longer than 10 characters.");
        }
        this.appointmentID = appointmentID;

        // Check and set appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must not be null and cannot be in the past.");
        }
        this.appointmentDate = appointmentDate;

        // Check and set description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and cannot be longer than 50 characters.");
        }
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Appointment ID: " + appointmentID +
                ", Date: " + dateFormat.format(appointmentDate) +
                ", Description: " + description;
    }
}
