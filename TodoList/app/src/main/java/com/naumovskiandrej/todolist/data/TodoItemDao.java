package com.naumovskiandrej.todolist.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TodoItemDao {
    @Query("SELECT * FROM todo_item WHERE is_completed = :isCompleted ORDER BY date DESC")
    List<TodoItem> getByCompletion(boolean isCompleted);

    @Insert
    void insertTodoTask(TodoItem item);

    @Update
    void updateTodoTask(TodoItem item);
}
