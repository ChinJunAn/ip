package duke;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    /**
     * Represents the list of task user has created, or loaded from file.
     */
    List<Task> list;

    /**
     * Constructor to create an instance of Tasklist
     */
    public TaskList() {
        this.list = new ArrayList<>();
    }

    /**
     * Method to add task into the Duke program
     *
     * @param t Task object representing task created
     */
    public String addTask(Task t) {
        this.list.add(t);
        return printCount() + t.printStatus();
    }

    /**
     * Method to assist loading task from file
     *
     * @param t Task object read from file
     */
    public void loadTask(Task t) {
        this.list.add(t);
    }

    /**
     * Method to remove task from the Duke program
     *
     * @param index Index of task in TaskList
     */
    public void removeTask(int index) {
        this.list.remove(index);
    }

    /**
     * Method to retrieve task from the TaskList
     *
     * @param index Index of task in TaskList
     * @return Task Object
     * @throws taskNotFoundException
     */
    public Task getTask(int index) {
        return this.list.get(index);
    }

    /**
     * Method to return an iterable list from TaskList
     *
     * @return List<Task></Task>
     */
    public List<Task> iterable() {
        return this.list;
    }

    /**
     * Method to calculate number of task in TaskList
     *
     * @return Int representation of count of Tasks in TaskList
     */
    public int count() {
        return this.list.size();
    }

    /**
     * Method to display count
     */
    public String printCount() {
        return "Now you have " + count() + " task(s) in the list.\n";
    }
}
