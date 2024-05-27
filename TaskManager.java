import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;

    public TaskManager() {
        tasks = new ArrayList<>();
        nextId = 1;
    }

    public void addTask(String title, String description, String priority, String status) {
        Task task = new Task(nextId++, title, description, priority, status);
        tasks.add(task);
    }

    public void editTask(int taskId, String title, String description, String priority, String status) {
        Task task = getTaskById(taskId);
        if (task != null) {
            if (title != null && !title.isEmpty()) task.setTitle(title);
            if (description != null && !description.isEmpty()) task.setDescription(description);
            if (priority != null && !priority.isEmpty()) task.setPriority(priority);
            if (status != null && !status.isEmpty()) task.setStatus(status);
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    public void deleteTask(int taskId) {
        Task task = getTaskById(taskId);
        if (task != null) {
            tasks.remove(task);
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public void viewAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void filterTasksByPriority(String priority) {
        for (Task task : tasks) {
            if (task.toString().contains("Priority: " + priority)) {
                System.out.println(task);
            }
        }
    }
}
