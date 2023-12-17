import static org.junit.Assert.*;
import org.junit.Test;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("T123", "TaskName", "TaskDescription");
        taskService.addTask(task);
        assertEquals(1, taskService.getTasks().size());
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("T123", "TaskName", "TaskDescription");
        taskService.addTask(task);
        taskService.deleteTask("T123");
        assertEquals(0, taskService.getTasks().size());
    }

    @Test
    public void testUpdateTaskName() {
        TaskService taskService = new TaskService();
        Task task = new Task("T123", "TaskName", "TaskDescription");
        taskService.addTask(task);
        taskService.updateTaskName("T123", "NewTaskName");
        assertEquals("NewTaskName", taskService.getTasks().get(0).getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService taskService = new TaskService();
        Task task = new Task("T123", "TaskName", "TaskDescription");
        taskService.addTask(task);
        taskService.updateTaskDescription("T123", "NewTaskDescription");
        assertEquals("NewTaskDescription", taskService.getTasks().get(0).getDescription());
    }

}
