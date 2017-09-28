public class Task {
    String name;
    boolean isComplete;

    public Task(String name) {
        this.name = name;
        isComplete = false;
    }

    public void complete() {
        this.isComplete = true;
    }
}
