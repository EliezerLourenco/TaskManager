package com.example.javaintroproject.controller;

import com.example.javaintroproject.model.Task;
import com.example.javaintroproject.model.TaskManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.time.LocalDate;

/**
 * Controller for the task management view.
 * Handles the interactions for adding, editing, and deleting tasks.
 */
public class TaskController {
    @FXML private TableView<Task> tasksTableView;
    @FXML private TableColumn<Task, String> taskNameColumn;
    @FXML private TableColumn<Task, String> descriptionColumn;
    @FXML private TableColumn<Task, LocalDate> dueDateColumn;
    @FXML private TableColumn<Task, String> statusColumn;
    @FXML private TextField taskNameField;
    @FXML private TextField descriptionField;
    @FXML private DatePicker dueDatePicker;
    @FXML private ComboBox<String> statusComboBox;


    @FXML private Button addButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;
    private TaskManager taskManager = new TaskManager();

    /**
     * Initializes the controller and sets up the task table view.
     */
    @FXML
    private void initialize() {
        taskNameColumn.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        statusComboBox.setItems(FXCollections.observableArrayList("Not Started", "In Progress", "Completed", "On Hold"));

        tasksTableView.setItems(taskManager.getTasks());
    }


    /**
     * Handles adding a new task to the task manager.
     */
    @FXML
    private void handleAddAction() {
        String taskName = taskNameField.getText();
        String description = descriptionField.getText();
        LocalDate dueDate = dueDatePicker.getValue();
        String status = statusComboBox.getValue();

        Task newTask = new Task(taskName, description, dueDate, status);
        taskManager.addTask(newTask);

        // Update the table view and clear the form for the next entry
        tasksTableView.setItems(taskManager.getTasks());
        clearForm();
    }


    /**
     * Handles editing the selected task.
     */
    @FXML
    private void handleEditAction() {
        Task selectedTask = tasksTableView.getSelectionModel().getSelectedItem();

        if (selectedTask != null) {
            String taskName = taskNameField.getText();
            String description = descriptionField.getText();
            LocalDate dueDate = dueDatePicker.getValue();
            String status = statusComboBox.getValue();

            if (!taskName.isEmpty()) {
                selectedTask.setTaskName(taskName);
            }
            if (!description.isEmpty()) {
                selectedTask.setDescription(description);
            }
            if (dueDate != null) {
                selectedTask.setDueDate(dueDate);
            }
            if (status != null && !status.isEmpty()) {
                selectedTask.setStatus(status);
            }

            tasksTableView.refresh();
            clearForm();
        }
    }



    /**
     * Handles deleting the selected task from the task manager.
     */
    @FXML
    private void handleDeleteAction() {
        Task selectedTask = tasksTableView.getSelectionModel().getSelectedItem();

        if (selectedTask != null) {
            taskManager.deleteTask(selectedTask);
            tasksTableView.setItems(taskManager.getTasks());
        }
    }

    /**
     * Clears the form fields.
     */
    private void clearForm() {
        taskNameField.clear();
        descriptionField.clear();
        dueDatePicker.setValue(null);
        tasksTableView.getSelectionModel().clearSelection();
    }
}
