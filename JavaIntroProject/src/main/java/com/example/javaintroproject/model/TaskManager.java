package com.example.javaintroproject.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Manages a list of tasks.
 */
public class TaskManager {
    private ObservableList<Task> tasks = FXCollections.observableArrayList();

    /**
     * Returns the list of tasks.
     *
     * @return An observable list of tasks.
     */
    public ObservableList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes a task from the list.
     *
     * @param task The task to delete.
     */
    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    /**
     * Updates a task at a specific index.
     *
     * @param index The index of the task to update.
     * @param newTask The updated task.
     */
    public void updateTask(int index, Task newTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, newTask);
        }
    }

    /**
     * Updates a task, replacing an old task with a new one.
     *
     * @param oldTask The old task to replace.
     * @param newTask The new task.
     */
    public void updateTask(Task oldTask, Task newTask) {
        int index = tasks.indexOf(oldTask);
        if (index != -1) {
            tasks.set(index, newTask);
        }
    }
}
