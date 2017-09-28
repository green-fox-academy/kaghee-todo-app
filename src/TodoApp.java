import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TodoApp {

    public TodoApp() {

    }

    public void exe() {
        System.out.println("\nCommand Line Todo application\n" +
                "=============================\n" +
                "\n" +
                "Command line arguments:\n" +
                " -l   Lists all the tasks\n" +
                " -a   Adds a new task\n" +
                " -r   Removes a task\n" +
                " -c   Completes a task");
    }

    public void listTasks() {
        Path myPath = Paths.get("tasks.txt");
        try {
            List<String> lines = Files.readAllLines(myPath);
            if (lines.isEmpty()) {
                System.out.println("No todos for today! :)");
            }
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + " - " + lines.get(i));
            }
        } catch(IOException e) {
            System.out.println("Unable to read file.");
        }
    }

    public void addTask(String newTask) {
        Path myPath = Paths.get("tasks.txt");
        try {
            List<String> lines = Files.readAllLines(myPath);
            lines.add(newTask);
            Files.write(myPath, lines);
        } catch(IOException e) {
            System.out.println("Unable to read file.");
        }
    }

    public void removeTask(int index) {
        Path myPath = Paths.get("tasks.txt");
        try {
            List<String> lines = Files.readAllLines(myPath);
            if (lines.size() < 2) {
                System.out.println("No can do. The file has less than 2 tasks.");
            } else {
                lines.remove(lines.get(index - 1));
            }
            Files.write(myPath, lines);
        } catch(IOException e) {
            System.out.println("Unable to read file.");
        }
    }


    public static void main(String[] args) {
        TodoApp app = new TodoApp();

        if (args.length == 0) {
            app.exe();
        } else if (args[0].equals("-l")) {
            app.listTasks();
        } else if (args[0].equals("-a")) {
            if (args.length == 1) {
                System.out.println("Unable to add: no task provided");
            } else {
                app.addTask(args[1]);
            }
        } else if (args[0].equals("-r")) {
            if (args.length == 1) {
                System.out.println("Unable to remove: no index provided");
            } else {
                app.removeTask(Integer.valueOf(args[1]));
            }
        }


    }
}
