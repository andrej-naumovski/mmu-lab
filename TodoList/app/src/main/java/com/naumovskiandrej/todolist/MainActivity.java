package com.naumovskiandrej.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.naumovskiandrej.todolist.data.ApplicationDatabase;
import com.naumovskiandrej.todolist.data.TodoItem;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private RecyclerView todoItemList;
    private TodoItemAdapter todoItemAdapter;
    private RecyclerView.LayoutManager todoItemLayoutManager;

    private ApplicationDatabase applicationDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        todoItemList = findViewById(R.id.todoItemList);

        mToolbar.setTitle("Sqlite TODO list");

        if(mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        applicationDatabase = ApplicationDatabase.getInstance(getApplicationContext());
        TodoItem todoItem = new TodoItem();
        todoItem.setTaskDescription("TODO Item 1");
        todoItem.setDate(new Date());
        todoItem.setCompleted(false);

        new AddTodoItem(getApplicationContext()).execute(todoItem);

        todoItemAdapter = new TodoItemAdapter(getApplicationContext(), this, false);
        todoItemList.setAdapter(todoItemAdapter);
        todoItemLayoutManager = new LinearLayoutManager(this);
        todoItemList.setLayoutManager(todoItemLayoutManager);
    }
}
