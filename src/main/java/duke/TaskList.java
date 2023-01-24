package duke;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public void addTask(Task t) {
        this.list.add(t);
        System.out.println("Got it. I've added this task: ");
        t.printStatus();
        printCount();
    }
    public void loadTask(Task t) {
        list.add(t);
    }
    public void removeTask(int index) {
        this.list.remove(index);
    }
    public Task getTask(int index) throws taskNotFoundException{
        try {
            return this.list.get(index);
        } catch (IndexOutOfBoundsException e){
            throw new taskNotFoundException();
        }
    }

    public int count() {
        return this.list.size();
    }

    public void printCount() {
        System.out.println("Now you have "+count()+" task(s) in the list.");
    }
}
