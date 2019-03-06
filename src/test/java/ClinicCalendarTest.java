import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicCalendarTest {

    @Test
    public void allowEntryOfAnAppointment() {
        // Set up, execute, verify...

        ClinicCalendar calendar = new ClinicCalendar();
        calendar.addAppointment("David", "Beckham", "avery",
                "25/06/2019 2:00 pm");

        List<PatientAppointment> appointments = calendar.getAppointments();
        PatientAppointment enteredAppt = appointments.get(0);

        assertNotNull(appointments);
        assertEquals(1, appointments.size());

        assertEquals("David", enteredAppt.getPatientFirstName());
        assertEquals("Beckham", enteredAppt.getPatientLastName());
        assertEquals(Doctor.avery, enteredAppt.getDoctor());
        assertEquals("25/06/2019 2:00 pm",
                enteredAppt.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a")));
    }

}