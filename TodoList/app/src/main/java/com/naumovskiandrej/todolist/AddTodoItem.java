package com.naumovskiandrej.todolist;

import android.content.Context;
import android.os.AsyncTask;

import com.naumovskiandrej.todolist.data.ApplicationDatabase;
import com.naumovskiandrej.todolist.data.TodoItem;

/**
 * Created by andrejnaumovski on 21.12.17.
 */

public class AddTodoItem extends AsyncTask<TodoItem, Void, Void> {
    private ApplicationDatabase applicationDatabase;

    public AddTodoItem(Context applicationContext) {
        applicationDatabase = ApplicationDatabase.getInstance(applicationContext);
    }

    @Override
    protected Void doInBackground(TodoItem... todoItems) {
        applicationDatabase.todoItemDao().insertTodoTask(todoItems[0]);
        return null;
    }
}


