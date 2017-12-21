package com.naumovskiandrej.todolist.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "todo_item")
public class TodoItem {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "task_description")
    private String taskDescription;
    @TypeConverters({TimestampConverter.class})
    @ColumnInfo(name = "date")
    private Date date;
    @ColumnInfo(name = "is_completed")
    boolean isCompleted;

    public TodoItem() {

    }

    public TodoItem(String taskDescription, Date date, boolean isCompleted) {
        this.taskDescription = taskDescription;
        this.date = date;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
