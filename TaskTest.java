/**
 * Author: Bobby Rust
 * Date: June 2, 2024
 */

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    /**
     * Tests the creation of a Task object with valid arguments.
     */
    @Test
    public void testTask() {
        Task task = new Task("Task 1", "Name 1", "Description 1");
        assertNotNull(task);
        assertEquals("Task 1", task.getID());
        assertEquals("Name 1", task.getName());
        assertEquals("Description 1", task.getDescription());
    }

    /**
     * Tests that an IllegalArgumentException is thrown when the ID is too long.
     */
    @Test
    public void testTaskIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(StringUtils.repeat("*", 11), "Name 1", "Description 1");
        });
    }

    /**
     * Tests that an IllegalArgumentException is thrown when the ID is null.
     */
    @Test
    public void testTaskIDNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name 1", "Description 1");
        });
    }

    /**
     * Tests that an IllegalArgumentException is thrown when the name is too long.
     */
    @Test
    public void testTaskNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 1", StringUtils.repeat("*", 21), "Description 1");
        });
    }

    /**
     * Tests that an IllegalArgumentException is thrown when the name is null.
     */
    @Test
    public void testTaskNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 1", null, "Description 1");
        });
    }

    /**
     * Tests that an IllegalArgumentException is thrown when the description is too long.
     */
    @Test
    public void testTaskDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 1", "Name 1", StringUtils.repeat("*", 51));
        });
    }

    /**
     * Tests that an IllegalArgumentException is thrown when the description is null.
     */
    @Test
    public void testTaskDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("Task 1", "Name 1", null);
        });
    }
}
