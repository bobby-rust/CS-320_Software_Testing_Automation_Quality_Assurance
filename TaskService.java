import java.util.HashMap;

public class TaskService {
    HashMap<String, Task> tasks = new HashMap<String, Task>(); // ID, Task

    /**
     * Adds a task to the tasks map.
     *
     * @param  task  the task to be added
     * @throws IllegalArgumentException  if the task is null
     */
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }

        if (tasks.containsKey(task.getID())) {
            throw new IllegalArgumentException(String.format("Task %s already exists.", task.getID()));
        }

        tasks.put(task.getID(), task);
    }


    /**
     * Deletes a task with the given ID from the tasks map.
     *
     * @param  id  the ID of the task to be deleted
     * @throws IllegalArgumentException  if the task with the given ID does not exist
     */
    public void deleteTask(String id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }

        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Task %s does not exist.", id));
        }

        tasks.remove(id);
    }


    /**
     * Updates the name of a task with the given ID.
     *
     * @param  id  the ID of the task to be updated
     * @param  name  the new name of the task
     * @throws IllegalArgumentException  if the task with the given ID does not exist
     */
    public void updateTaskName(String id, String name) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }

        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Task %s does not exist.", id));
        }

        tasks.get(id).setName(name);
    }

    /**
     * Updates the description of a task with the given ID.
     *
     * @param  id  the ID of the task to be updated
     * @param  description  the new description of the task
     * @throws IllegalArgumentException  if the task with the given ID does not exist
     */
    public void updateTaskDescription(String id, String description) throws IllegalArgumentException {
        if (!tasks.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Task %s does not exist.", id));
        }

        tasks.get(id).setDescription(description);
    }
}