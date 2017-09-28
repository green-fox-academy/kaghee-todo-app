import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

//    public void exe(String argument) {
//        if (argument == "-l") {
//            listTasks();
//        } else {
//            exe();
//        }
//    }

    public void listTasks() {

        Path myPath = Paths.get("tasks.txt");
        try {
            List<String> lines = Files.readAllLines(myPath);
            System.out.println("\n");
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



    public static void main(String[] args) {
        TodoApp app = new TodoApp();

        if (args.length == 0) {
            app.exe();
        } else if (args.length > 0 && args[0].equals("-l")) {
            app.listTasks();
        }


    }
}
