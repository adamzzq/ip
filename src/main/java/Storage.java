import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exception.AdamException;
import task.TaskList;
import ui.Message;

/*
 * Storage class is responsible for saving and loading tasks from the local data file.
 */
/**
 * The Storage class handles the saving and loading of tasks to/from a file.
 */
public class Storage {
    private static final String TASKS_FILE_PATH = "tasks.dat";

    /**
     * Saves the given TaskList to a file.
     *
     * @param tasks The TaskList to be saved.
     * @throws AdamException If there is an error saving the file.
     */
    public static void saveTasks(TaskList tasks) throws AdamException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TASKS_FILE_PATH))) {
            outputStream.writeObject(tasks);
        } catch (IOException error) {
            throw new AdamException(Message.FILE_SAVE_ERROR_MESSAGE);
        }
    }

    /**
     * Loads the TaskList from a file.
     *
     * @return The loaded TaskList.
     * @throws AdamException If there is an error loading the file.
     */
    public static TaskList loadTasks() throws AdamException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(TASKS_FILE_PATH))) {
            return (TaskList) inputStream.readObject();
        } catch (IOException | ClassNotFoundException error) {
            throw new AdamException(Message.FILE_LOAD_ERROR_MESSAGE);
        }
    }
}