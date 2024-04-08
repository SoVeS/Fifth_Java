import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Написать практос по Жаве", "4 практос про фигуры", 1);
        Task task2 = new Task("Умыться утром", "Надо будет нанести крем", 2);
        Task task3 = new Task("Приготоить ужин", "Пожарить отивные и сварить макарошки", 3);

        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);

        System.out.println("Список всех задач:");
        toDoList.displayAllTasks();
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить новую задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Отметить задачу как выполненную");
            System.out.println("4. Показать список всех задач");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем оставшийся символ новой строки

            switch (choice) {
                case 1:
                    System.out.println("Введите название задачи:");
                    String title = scanner.nextLine();
                    System.out.println("Введите описание задачи:");
                    String description = scanner.nextLine();
                    System.out.println("Введите приоритет задачи (целое число):");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Считываем оставшийся символ новой строки
                    Task newTask = new Task(title, description, priority);
                    toDoList.addTask(newTask);
                    System.out.println("Задача успешно добавлена.");
                    break;
                case 2:
                    System.out.println("Введите индекс задачи, которую хотите удалить:");
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine(); // Считываем оставшийся символ новой строки
                    toDoList.removeTask(indexToRemove);
                    System.out.println("Задача успешно удалена.");
                    break;
                case 3:
                    System.out.println("Введите индекс задачи, которую хотите отметить как выполненную:");
                    int indexToMarkAsDone = scanner.nextInt();
                    scanner.nextLine(); // Считываем оставшийся символ новой строки
                    toDoList.markAsDone(indexToMarkAsDone);
                    System.out.println("Задача успешно отмечена как выполненная.");

                    break;
                case 4:
                    System.out.println("Список всех задач:");
                    toDoList.displayAllTasks();
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}
interface TaskManager {
    void addTask(Task task);
    void removeTask(int index);
    void markAsDone(int index);
    void displayAllTasks();
}
class Task {
    private String title;
    private String description;
    private int priority;
    private boolean isDone;
    private Date date;
    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isDone = false;
    }
    public void markAsDone() {
        this.isDone = true;
    }
    public String toString() {
        return "Задача: " + title + ", Описание: " + description + ", Приоритет: " + priority + ", Статус: " + (isDone ? "Выполнено" : "Не выполнено");
    }
}
class ToDoList implements TaskManager {
    private List<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(int index) {
        tasks.remove(index);
    }

    @Override
    public void markAsDone(int index) {
        Task task = tasks.get(index);
        task.markAsDone();
    }

    @Override
    public void displayAllTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }
}
