package model;

import model.premodel.Date;
import model.premodel.Priority;

import java.util.Objects;

public class Task {
    private int id;
    private String taskName;
    private Priority priority;
    private String description;
    private Date date;


    public Task(int id, String taskName, Priority priority, String description, Date date){
        this.id = id;
        this.taskName = taskName;
        this.priority = priority;
        this.description = description;
        this.date = date;
    }
    public Task(){
        this.id = 0;
        this.taskName = null;
        this.priority = null;
        this.description = null;
        this.date = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;
        return Objects.equals(taskName, task.taskName) && priority == task.priority && Objects.equals(description, task.description) && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, priority, description, date);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id + '\'' +
                ", taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
