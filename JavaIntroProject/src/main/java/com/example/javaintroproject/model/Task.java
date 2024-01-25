package com.example.javaintroproject.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Task {
    private final StringProperty taskName = new SimpleStringProperty(this, "taskName", "");
    private final StringProperty description = new SimpleStringProperty(this, "description", "");
    private final ObjectProperty<LocalDate> dueDate = new SimpleObjectProperty<>(this, "dueDate", LocalDate.now());
    private final StringProperty status = new SimpleStringProperty(this, "status", "");

    public Task(String taskName, String description, LocalDate dueDate, String status) {
        this.taskName.set(taskName);
        this.description.set(description);
        this.dueDate.set(dueDate);
        this.status.set(status);
    }

    public StringProperty taskNameProperty() { return taskName; }
    public StringProperty descriptionProperty() { return description; }
    public ObjectProperty<LocalDate> dueDateProperty() { return dueDate; }
    public StringProperty statusProperty() { return status; }

    // Getters and setters that use the properties
    public String getTaskName() { return taskName.get(); }
    public void setTaskName(String taskName) { this.taskName.set(taskName); }

    public String getDescription() { return description.get(); }
    public void setDescription(String description) { this.description.set(description); }

    public LocalDate getDueDate() { return dueDate.get(); }
    public void setDueDate(LocalDate dueDate) { this.dueDate.set(dueDate); }

    public String getStatus() { return status.get(); }
    public void setStatus(String status) { this.status.set(status); }
}
