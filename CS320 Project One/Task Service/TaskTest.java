import static org.junit.Assert.*;
import org.junit.Test;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("T123", "TaskName", "TaskDescription");
        assertEquals("T123", task.getTaskId());
        assertEquals("TaskName", task.getName());
        assertEquals("TaskDescription", task.getDescription());
    }

}
