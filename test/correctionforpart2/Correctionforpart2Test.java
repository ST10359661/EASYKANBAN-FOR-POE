/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package correctionforpart2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for Task class
 */
public class Correctionforpart2Test {

    private tasks[] tasks;

    @Before
    public void setUp() {
        // Initialize the array with Task data
        tasks = new tasks[]{
           // new tasks("Create Login", "Mike Smith", 5, "To Do"),
            //new tasks("Create Add Features", "Edward Harrison", 8, "Doing"),
           // new tasks("Create Reports", "Samantha Paulson", 2, "Done"),
           // new tasks("Add Arrays", "Glenda Oberholzer", 11, "To Do")
        };
    }

    @After
    public void tearDown() {
        tasks = null;
    }

    // Test for correct number of tasks
    @Test
    public void testNumberOfTasks() {
        assertEquals("There should be 4 tasks", 4, tasks.length);
    }

    // Test for Task 1 data
    @Test
    public void testTask1() {
        tasks task1 = tasks[0];
        assertEquals("Developer for Task 1 should be Mike Smith", "Mike Smith", task1.getDeveloperDetails());
        assertEquals("Task name for Task 1 should be Create Login", "Create Login", task1.getTaskName());
        assertEquals("Task duration for Task 1 should be 5 hours", 5, task1.getTaskDuration());
        assertEquals("Task status for Task 1 should be To Do", "To Do", task1.getTaskStatus());
    }

    // Test for Task 2 data
    @Test
    public void testTask2() {
        tasks task2 = tasks[1];
        assertEquals("Developer for Task 2 should be Edward Harrison", "Edward Harrison", task2.getDeveloperDetails());
        assertEquals("Task name for Task 2 should be Create Add Features", "Create Add Features", task2.getTaskName());
        assertEquals("Task duration for Task 2 should be 8 hours", 8, task2.getTaskDuration());
        assertEquals("Task status for Task 2 should be Doing", "Doing", task2.getTaskStatus());
    }

    // Test for Task 3 data
    @Test
    public void testTask3() {
        tasks task3 = tasks[2];
        assertEquals("Developer for Task 3 should be Samantha Paulson", "Samantha Paulson", task3.getDeveloperDetails());
        assertEquals("Task name for Task 3 should be Create Reports", "Create Reports", task3.getTaskName());
        assertEquals("Task duration for Task 3 should be 2 hours", 2, task3.getTaskDuration());
        assertEquals("Task status for Task 3 should be Done", "Done", task3.getTaskStatus());
    }

    // Test for Task 4 data
    @Test
    public void testTask4() {
        tasks task4 = tasks[3];
        assertEquals("Developer for Task 4 should be Glenda Oberholzer", "Glenda Oberholzer", task4.getDeveloperDetails());
        assertEquals("Task name for Task 4 should be Add Arrays", "Add Arrays", task4.getTaskName());
        assertEquals("Task duration for Task 4 should be 11 hours", 11, task4.getTaskDuration());
        assertEquals("Task status for Task 4 should be To Do", "To Do", task4.getTaskStatus());
    }

    // Additional test for checking all tasks have valid developer names
    @Test
    public void testAllDevelopers() {
        assertNotNull("Task 1 Developer should not be null", tasks[0].getDeveloperDetails());
        assertNotNull("Task 2 Developer should not be null", tasks[1].getDeveloperDetails());
        assertNotNull("Task 3 Developer should not be null", tasks[2].getDeveloperDetails());
        assertNotNull("Task 4 Developer should not be null", tasks[3].getDeveloperDetails());
    }

    // Test for correct Task Status of each task
    @Test
    public void testTaskStatus() {
        assertEquals("Task 1 should be To Do", "To Do", tasks[0].getTaskStatus());
        assertEquals("Task 2 should be Doing", "Doing", tasks[1].getTaskStatus());
        assertEquals("Task 3 should be Done", "Done", tasks[2].getTaskStatus());
        assertEquals("Task 4 should be To Do", "To Do", tasks[3].getTaskStatus());
    }
}
