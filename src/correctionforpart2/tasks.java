/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correctionforpart2;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RC_Student_lab
 */
public class tasks {
    
      
       

   private String TaskID;
    private String TaskName;
    private int TaskNumber;
    private String TaskDescription;
    private String DevelopersDetails;
    private int TaskDuration;
    private String TaskStatus;

    // Constructor
    public tasks(String TaskName, int TaskNumber, String TaskDescription, String DevelopersDetails, int TaskDuration, String TaskStatus) {
        this.TaskName = TaskName;
        this.TaskNumber = TaskNumber;
        this.TaskDescription = TaskDescription;
        this.DevelopersDetails = DevelopersDetails;
        this.TaskDuration = TaskDuration;
        this.TaskStatus = TaskStatus;
    }

    // Getters and Setters
    public String getTaskID() { return TaskID; }
    public void setTaskID(String TaskID) { this.TaskID = TaskID; }

    public String getTaskName() { return TaskName; }
    public void setTaskName(String TaskName) { this.TaskName = TaskName; }

    public int getTaskNumber() { return TaskNumber; }
    public void setTaskNumber(int TaskNumber) { this.TaskNumber = TaskNumber; }

    public String getTaskDescription() { return TaskDescription; }
    public void setTaskDescription(String TaskDescription) { this.TaskDescription = TaskDescription; }

    public String getDeveloperDetails() { return DevelopersDetails; }
    public void setDeveloperDetails(String DevelopersDetails) { this.DevelopersDetails = DevelopersDetails; }

    public int getTaskDuration() { return TaskDuration; }
    public void setTaskDuration(int TaskDuration) { this.TaskDuration = TaskDuration; }

    public String getTaskStatus() { return TaskStatus; }
    public void setTaskStatus(String TaskStatus) { this.TaskStatus = TaskStatus; }

    // Check Task Description length
    public boolean checkTaskDescription() {
        if (TaskDescription.length() < 50) {
            JOptionPane.showMessageDialog(null, "Task description must be at least 50 characters.");
            return false;
        }
        return true;
    }

    // Create Task ID
    public String createTaskID() {
        TaskID = TaskName.substring(0, 2).toUpperCase() + ":" + TaskNumber + ":" + DevelopersDetails.substring(DevelopersDetails.length() - 3).toUpperCase();
        return TaskID;
    }

    // Display Task Details
    public void displayTaskDetails() {
        JOptionPane.showMessageDialog(null, 
            "Task Details:\n" +
            "Task ID: " + TaskID + "\n" +
            "Task Name: " + TaskName + "\n" +
            "Developer: " + DevelopersDetails + "\n" +
            "Description: " + TaskDescription + "\n" +
            "Task Duration: " + TaskDuration + " hours\n" +
            "Status: " + TaskStatus);
    }
  
    // Method to check Task Status for "Done" tasks
    public boolean isTaskDone() {
        return "Done".equalsIgnoreCase(TaskStatus);

}}