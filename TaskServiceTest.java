/**
 * Author: Bobby Rust
 * Date: June 2, 2024
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    /**
     * Tests creating a TaskService object.
     */
    @Test
    public void testTaskService() {
        TaskService taskService = new TaskService();
        assertNotNull(taskService);
        assertNotNull(taskService.tasks);
        assertTrue(taskService.tasks.isEmpty());
    }

    /**
     * Tests adding a task to the tasks map.
     */
    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("Task 1", "Name 1", "Description 1");
        taskService.addTask(task);
        assertNotNull(taskService.tasks.get(task.getID()));

        assertEquals("Task 1", taskService.tasks.get(task.getID()).getID());
        assertEquals("Name 1", taskService.tasks.get(task.getID()).getName());
        assertEquals("Description 1", taskService.tasks.get(task.getID()).getDescription());

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task); // Task already exists
        });
    }

    /**
     * Tests deleting a task from the tasks map.
     */
    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("Task 1", "Name 1", "Description 1");
        taskService.addTask(task);
        taskService.deleteTask(task.getID());
        assertNull(taskService.tasks.get(task.getID()));

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("Task 2"); // Task does not exist
        });
    }

    /**
     * Tests updating a task name in the tasks map.
     */
    @Test
    public void testUpdateTaskName() {
        Task task = new Task("Task 1", "Name 1", "Description 1");
        TaskService taskService = new TaskService();

        taskService.addTask(task);
        taskService.updateTaskName(task.getID(), "Name 2");

        assertEquals("Name 2", taskService.tasks.get(task.getID()).getName()); // Successfully update name

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName(null, "Name 2"); // ID cannot be null
        });

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("Task 2", "Name 3"); // Task does not exist
        });
    }

    /**
     * Tests updating a task description in the tasks map.
     */
    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("Task 1", "Name 1", "Description 1");
        TaskService taskService = new TaskService();

        taskService.addTask(task);
        taskService.updateTaskDescription(task.getID(), "Description 2");

        assertEquals("Description 2", taskService.tasks.get(task.getID()).getDescription());

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription(null, "Description 2"); // ID cannot be null
        });

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("Task 2", "Description 3"); // Task does not exist
        });
    }
}
