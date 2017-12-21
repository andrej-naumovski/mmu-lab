package com.naumovskiandrej.todolist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.naumovskiandrej.todolist.data.ApplicationDatabase;
import com.naumovskiandrej.todolist.data.TodoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrejnaumovski on 21.12.17.
 */

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.ViewHolder> {
    public List<TodoItem> todoItems;
    private ApplicationDatabase applicationDatabase;
    private Context activityContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemDescription;
        public TextView date;
        public CheckBox markCompleted;

        public ViewHolder(View view) {
            super(view);
            itemDescription = view.findViewById(R.id.item_description);
            date = view.findViewById(R.id.date);
            markCompleted = view.findViewById(R.id.mark_completed);
        }
    }

    public TodoItemAdapter(Context applicationContext, Context activityContext, boolean areCompleted) {
        new GetTodoItems(applicationContext, this).execute(areCompleted);
        this.activityContext = activityContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        v.setOnClickListener(view -> activityContext.startActivity(new Intent(activityContext, EditActivity.class)));
        return new TodoItemAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TodoItem item = todoItems.get(position);
        holder.itemDescription.setText(item.getTaskDescription());
        holder.markCompleted.setChecked(item.isCompleted());
        holder.markCompleted.setText(item.isCompleted() ? "Completed" : "Complete");
        holder.markCompleted.setEnabled(!item.isCompleted());
        holder.date.setText(item.getDate().toString());

        holder.markCompleted.setOnCheckedChangeListener((view, isChecked) -> {
            item.setCompleted(isChecked);
            applicationDatabase.todoItemDao().updateTodoTask(item);
            todoItems.remove(item);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
