import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View All Tasks");
            System.out.println("5. Filter Tasks by Priority");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Task Priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter Task Status (Pending/In Progress/Completed): ");
                    String status = scanner.nextLine();
                    taskManager.addTask(title, description, priority, status);
                    break;
                case 2:
                    System.out.print("Enter Task ID to Edit: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter New Title (or press Enter to skip): ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Description (or press Enter to skip): ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter New Priority (High/Medium/Low) (or press Enter to skip): ");
                    String newPriority = scanner.nextLine();
                    System.out.print("Enter New Status (Pending/In Progress/Completed) (or press Enter to skip): ");
                    String newStatus = scanner.nextLine();
                    taskManager.editTask(taskId, newTitle, newDescription, newPriority, newStatus);
                    break;
                case 3:
                    System.out.print("Enter Task ID to Delete: ");
                    taskId = scanner.nextInt();
                    scanner.nextLine();  
                    taskManager.deleteTask(taskId);
                    break;
                case 4:
                    taskManager.viewAllTasks();
                    break;
                case 5:
                    System.out.print("Enter Priority to Filter (High/Medium/Low): ");
                    priority = scanner.nextLine();
                    taskManager.filterTasksByPriority(priority);
                    break;
                case 6:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
