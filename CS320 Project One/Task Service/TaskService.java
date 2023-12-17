import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        // Check for unique task ID
        for (Task t : tasks) {
            if (t.getTaskId().equals(task.getTaskId())) {
                throw new IllegalArgumentException("Task ID must be unique.");
            }
        }
        tasks.add(task);
    }

    public void deleteTask(String taskId) {
        tasks.removeIf(task -> task.getTaskId().equals(taskId));
    }

    public void updateTaskName(String taskId, String newName) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setName(newName);
                return;
            }
        }
        throw new IllegalArgumentException("Task not found.");
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setDescription(newDescription);
                return;
            }
        }
        throw new IllegalArgumentException("Task not found.");
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
