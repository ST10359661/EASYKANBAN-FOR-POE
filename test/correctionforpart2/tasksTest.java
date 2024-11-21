/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package correctionforpart2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class tasksTest {
     private tasks task;

    // Test Data
    private static final String TASK_NAME = "Login Feature";
    private static final String TASK_DESCRIPTION = "Create Login to authenticate users";
    private static final String DEVELOPER_NAME = "Robyn Harrison";
    private static final int TASK_DURATION = 8;
    private static final String TASK_STATUS = "To Do";
    
    
    public tasksTest() {
    }
    
    @Before
    public void setUp() {
        // Create a task instance before each test using provided test data
        task = new tasks(TASK_NAME, 1, TASK_DESCRIPTION, DEVELOPER_NAME, TASK_DURATION, TASK_STATUS);
    }

    // Tear down after each test
    @After
    public void tearDown() {
        task = null;
    }

    // Test for creating Task ID
    @Test
    public void testCreateTaskID() {
        // Expected Task ID format: "LO:1:SON"
        String expectedTaskID = "LO:1:SON";
        assertEquals("Task ID should be 'LO:1:SON'", expectedTaskID, task.createTaskID());
    }

    // Test for valid task description (should be at least 50 characters)
    @Test
    public void testCheckTaskDescription_validDescription() {
        boolean isValid = task.checkTaskDescription();
        assertTrue("Task description should be valid (<= 50 characters).", isValid);
    }

    // Test for invalid task description (less than 50 characters)
    @Test
    public void testCheckTaskDescription_invalidDescription() {
        // Modify task description to be shorter than 50 characters
        tasks shortTask = new tasks("Short Task", 2, "Short", "Robyn Harrison", 5, "To Do");
        boolean isValid = shortTask.checkTaskDescription();
        assertFalse("Task description should be invalid (< 50 characters).", isValid);
    }

    // Test for displaying task details (no exceptions should be thrown)
    @Test
    public void testDisplayTaskDetails() {
        try {
            task.displayTaskDetails();
        } catch (Exception e) {
            fail("Exception should not be thrown when displaying task details.");
        }
    }

    // Test for checking if the task is "Done"
    @Test
    public void testIsTaskDone() {
        assertFalse("Task should not be marked as done initially.", task.isTaskDone());
        
        // Change the status to "Done"
        task.setTaskStatus("Done");
        assertTrue("Task should be marked as done after changing status.", task.isTaskDone());
    }

    // Additional test for Task's Developer Name (if necessary)
    @Test
    public void testDeveloperName() {
        assertEquals("Developer name should match", DEVELOPER_NAME, task.getDeveloperDetails());
    }

    // Additional test for Task Duration
    @Test
    public void testTaskDuration() {
        assertEquals("Task duration should match", TASK_DURATION, task.getTaskDuration());
    }

    // Test for Task Status (initially "To Do")
    @Test
    public void testTaskStatus() {
        assertEquals("Initial task status should be 'To Do'", TASK_STATUS, task.getTaskStatus());
        
        // Change the status and verify
        task.setTaskStatus("Doing");
        assertEquals("Task status should be 'Doing' after change", "Doing", task.getTaskStatus());
    }
    
     
}
