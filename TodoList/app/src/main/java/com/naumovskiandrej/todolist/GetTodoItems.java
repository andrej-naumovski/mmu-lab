package com.naumovskiandrej.todolist;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.naumovskiandrej.todolist.data.ApplicationDatabase;
import com.naumovskiandrej.todolist.data.TodoItem;

import java.util.List;

/**
 * Created by andrejnaumovski on 21.12.17.
 */

public class GetTodoItems extends AsyncTask<Boolean, Void, List<TodoItem>> {
    private ApplicationDatabase applicationDatabase;
    private TodoItemAdapter adapter;

    public GetTodoItems(Context applicationContext, TodoItemAdapter adapter) {
        applicationDatabase = ApplicationDatabase.getInstance(applicationContext);
        this.adapter = adapter;
    }

    @Override
    protected List<TodoItem> doInBackground(Boolean... booleans) {
        return applicationDatabase.todoItemDao().getByCompletion(booleans[0]);
    }

    @Override
    protected void onPostExecute(List<TodoItem> todoItems) {
        adapter.todoItems = todoItems;
        adapter.notifyDataSetChanged();
    }
}
