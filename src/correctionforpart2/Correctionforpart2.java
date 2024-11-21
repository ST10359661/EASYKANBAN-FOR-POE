/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correctionforpart2;
//part 1

import java.util.Scanner;

//part2
import javax.swing.JOptionPane;
import javax.swing.JDialog;

/**
 *
 * @author RC_Student_lab
 */
public class Correctionforpart2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //part 1
        Scanner obj = new Scanner(System.in);
        login myobj = new login();

        //part 2 and 3
        JDialog window = new JDialog();
        window.setAlwaysOnTop(true);
        //tasks MyObj = new tasks();

        //Registration
        //username
        String Username = "";
        do {
            System.out.println("Enter your Username:");
            Username = obj.nextLine();
        } while (!myobj.ValidateUsername(Username));

        //Enter your FirstName
        System.out.println("Enter your Firstname ");
        String firstname = obj.nextLine();

        //Enter your Lastname
        System.out.println("Enter your Lastname");
        String lastname = obj.nextLine();

        //Enter your Password
        String Password = "";
        do {
            System.out.println("Enter your Password");
            Password = obj.nextLine();
        } while (!myobj.ValidatePassword(Password));

        //login
        System.out.println("Login");

        System.out.print("\nEnter username: ");
        String login_user = obj.nextLine();

        System.out.print("\nEnter password; ");
        String login_password = obj.nextLine();

//instance
        login create_user = new login();

//then pass the values
        boolean found_or_not_found = create_user.check_user(Username, Password, login_user, login_password);

        create_user.ValidadateMessage(found_or_not_found, firstname, lastname);

        //part 3
        
        //populate my arrays
        String[] taskName = new String[100];
        String[] developersDetails = new String[100];
        String[] taskID = new String[100];
        int[] taskDurations = new int[100];
        String[] taskStatus = new String[100];
        

        int TaskCount = 0;

        // welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKaban");

        // Options menu
        boolean running = true;
        while (running) {
            String Options = JOptionPane.showInputDialog(null, "Select one of the options:"
                    + "\n1. Add Task"
                    + "\n2. Show Report"
                    + "\n3.Search task"
                    + "\n4.Search task by developers name"
                    + "\n5. delete task"
                    + "\n6. Quit", JOptionPane.PLAIN_MESSAGE);

            int IntegerOptions;
            try {
                IntegerOptions = Integer.parseInt(Options);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                continue;
            }

            switch (IntegerOptions) {
                case 1:
                    // Add tasks
                    String taskCountString = JOptionPane.showInputDialog(null, "How many tasks would you like to enter?");
                    int taskCount = Integer.parseInt(taskCountString);

                    for (int i = 0; i < taskCount; i++) {
                        String TaskName = JOptionPane.showInputDialog(null, "Please enter the task name:");
                        String TaskDescription = JOptionPane.showInputDialog(null, "Enter the task description (at least 50 characters):");

                        // Ensure description is at least 50 characters long
                        if (TaskDescription.length() > 50) {
                            JOptionPane.showMessageDialog(null, "Task description must be at least 50 characters.");
                            continue;
                        }

                        String DevelopersDetails = JOptionPane.showInputDialog(null, "Enter the developer's name and surname:");
                        String TaskDurationString = JOptionPane.showInputDialog(null, "Task duration (in hours):");
                        int TaskDuration;
                        try {
                            TaskDuration = Integer.parseInt(TaskDurationString);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid number for Task Duration.");
                            continue;
                        }

                        String[] statusOptions = {"To Do", "Done", "Doing"};
                        String Status = (String) JOptionPane.showInputDialog(null,
                                "Select Task Status:",
                                "Task Status",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                statusOptions,
                                statusOptions[0]);

                        // Create a new task object
                        tasks newTask = new tasks(TaskName, i + 1, TaskDescription, DevelopersDetails, TaskDuration, Status);

                        // Display task details
                        newTask.createTaskID();
                        newTask.displayTaskDetails();
                        
                
                        // Store task details in arrays
                        taskName[TaskCount] = TaskName;
                        developersDetails[TaskCount] = DevelopersDetails;
                        taskDurations[TaskCount] = TaskDuration;
                        taskStatus[TaskCount] = Status;
                        taskID[TaskCount] = newTask.createTaskID();  // Create and store TaskID

                        // Display task details
                        newTask.displayTaskDetails();

                        // Increment TaskCount
                        TaskCount++;
               
                    }
                    break;

                case 2:
                    // Show all tasks report
                    TaskReport.showReport(taskName, developersDetails, taskID, taskDurations, taskStatus, TaskCount);
                     // Show done tasks
                    TaskReport.showDoneTasks(developersDetails, taskName, taskDurations, taskStatus, TaskCount);
                    
                     TaskReport.showLongestTask(developersDetails, taskName, taskDurations, TaskCount);
                    break;

                case 3:
                    // Search task by Task Name
                    String searchTaskName = JOptionPane.showInputDialog("Enter Task Name to search:");
                    boolean taskFound = false;
                    for (int i = 0; i < TaskCount; i++) {
                        if (taskName[i].equalsIgnoreCase(searchTaskName)) {
                            JOptionPane.showMessageDialog(null, "Task Found:\n" +
                                    "Task Name: " + taskName[i] + "\n" +
                                    "Developer Details: " + developersDetails[i] + "\n" +
                                    "Task Status: " + taskStatus[i]);
                            taskFound = true;
                            break;
                        }
                    }
                    if (!taskFound) {
                        JOptionPane.showMessageDialog(null, "Task with name '" + searchTaskName + "' not found.");
                    }
                    break;

                case 4:
                    // Search task by Developer's Name
                    String searchDeveloperName = JOptionPane.showInputDialog("Please enter the developers details to search the tasks:");
                    boolean developerFound = false;
                    StringBuilder developerTasks = new StringBuilder("Tasks assigned to " + searchDeveloperName + ":\n");

                    for (int i = 0; i < TaskCount; i++) {
                        if (developersDetails[i].equalsIgnoreCase(searchDeveloperName)) {
                            developerTasks.append("Task Name: " + taskName[i] + "\n" +
                                    "Task Status: " + taskStatus[i] + "\n\n");
                            developerFound = true;
                        }
                    }

                    if (developerFound) {
                        JOptionPane.showMessageDialog(null, developerTasks.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No tasks found for developerDetails " + searchDeveloperName);
                    }
                    break;
                case 5:
                   // Delete task by Task Name
                    String taskNameToDelete = JOptionPane.showInputDialog("Enter the Task Name to delete:");

                    boolean taskDeleted = false;
                    for (int i = 0; i < TaskCount; i++) {
                        if (taskName[i].equalsIgnoreCase(taskNameToDelete)) {
                            // Shift tasks
                            for (int j = i; j < TaskCount - 1; j++) {
                                taskName[j] = taskName[j + 1];
                                developersDetails[j] = developersDetails[j + 1];
                                taskID[j] = taskID[j + 1];
                                taskDurations[j] = taskDurations[j + 1];
                                taskStatus[j] = taskStatus[j + 1];
                            }
                            taskName[TaskCount - 1] = null;
                            developersDetails[TaskCount - 1] = null;
                            taskID[TaskCount - 1] = null;
                            taskDurations[TaskCount - 1] = 0;
                            taskStatus[TaskCount - 1] = null;
                            TaskCount--;
                            taskDeleted = true;
                            JOptionPane.showMessageDialog(null, "Task '" + taskNameToDelete + "' has been deleted.");
                            break;
                        }
                    }

                    if (!taskDeleted) {
                        JOptionPane.showMessageDialog(null, "Task with name '" + taskNameToDelete + "' not found.");
                    }
                    break;
                        



                
                case 6:
                    JOptionPane.showMessageDialog(null, "Exiting program. THANK YOU.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
        
    }
 
    }

