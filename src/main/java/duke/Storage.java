package duke;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class Storage {
    /**
     * Represent a Storage object that controls writing and loading function of the Duke program.
     */
    String fp;
    File f;
    Map<String, Task> taskMap;

    /**
     * Constructor for an instance of Storage.
     * @param fp file path to save/load file
     * @throws IOException
     */
    public Storage(String fp) throws IOException{
        this.fp = fp;
        this.f = new File(fp);
        if (f.createNewFile()) {}

        this.taskMap = TaskMap.tm;
    }

    /**
     * Method to load information from previously saved task defined in file
     * @return TaskList object for Function to manipulate
     */
    public TaskList load() {
        TaskList tl = new TaskList();
        try  {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String l = sc.nextLine();
                String[] line = l.split(" \\| ");
                Task t = taskMap.get(line[0]);
                t.setStatus(line[1].equals("X")?true:false);
                t.configure(Arrays.copyOfRange(line, 2, line.length));
                tl.loadTask(t);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (DateTimeParseException e){
            System.out.println("Task file corrupted");
            e.printStackTrace();
        }

        return tl;
    }

    /**
     * Method to write onto file tasks that have been scheduled.
     * @param tl Tasklist object to determine task to write onto file.
     */
    public void save(TaskList tl) {
        //overwrite all in tasklist into file
        try{
            FileWriter fw = new FileWriter(fp);
            for (int i = 0; i < tl.count(); i++) {
                fw.write(tl.getTask(i).toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (DukeException e) {
            System.out.println(e);
        }
    }


}
