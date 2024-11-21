/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correctionforpart2;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class TaskReport {
  // Show Report Method to display all tasks
    public static void showReport(String[] taskName, String[] developersDetails, String[] taskID,
                                  int[] taskDurations, String[] taskStatus, int taskCount) {
        StringBuilder report = new StringBuilder();
        report.append("Task Report:\n\n");

        for (int i = 0; i < taskCount; i++) {
            report.append("Task Name:  ").append(taskName[i]).append("\n");
            report.append("Developer: ").append(developersDetails[i]).append("\n");
            report.append("Task ID: ").append(taskID[i]).append("\n");
            report.append("Task Duration: ").append(taskDurations[i]).append(" hours\n");
            report.append("Task Status: ").append(taskStatus[i]).append("\n\n");
        }

        // Display the task report in a dialog
        JOptionPane.showMessageDialog(null, report.toString());
    }

    // Show tasks with "Done" status
    public static void showDoneTasks(String[] developersDetails, String[] taskName,
                                      int[] taskDurations, String[] taskStatus, int taskCount) {
        StringBuilder report = new StringBuilder();
        report.append("Completed Tasks (Status: Done):\n\n");

        boolean hasCompletedTasks = false;

        for (int i = 0; i < taskCount; i++) {
            if ("Done".equalsIgnoreCase(taskStatus[i])) {
                report.append("Task Name: ").append(taskName[i]).append("\n");
                report.append("Developer: ").append(developersDetails[i]).append("\n");
                report.append("Task Duration: ").append(taskDurations[i]).append(" hours\n\n");
                hasCompletedTasks = true;
            }
        }

        if (!hasCompletedTasks) {
            report.append("No tasks are marked as Done.\n");
        }

        // Show the list of done tasks
        JOptionPane.showMessageDialog(null, report.toString());
    }

    // Show task with the longest duration
    public static void showLongestTask(String[] developersDetails, String[] taskName,
                                       int[] taskDurations, int taskCount) {
        int longestTaskIndex = -1;
        int longestDuration = 0;

        // Find the task with the longest duration
        for (int i = 0; i < taskCount; i++) {
            if (taskDurations[i] > longestDuration) {
                longestDuration = taskDurations[i];
                longestTaskIndex = i;
            }
        }

        if (longestTaskIndex != -1) {
            // Display task details for the longest task
            String report = "Task with the Longest Duration:\n\n" +
                    "Task Name: " + taskName[longestTaskIndex] + "\n" +
                    "Developer: " + developersDetails[longestTaskIndex] + "\n" +
                    "Duration: " + taskDurations[longestTaskIndex] + " hours\n";
            JOptionPane.showMessageDialog(null, report);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks available.");
        }
    }  
}
