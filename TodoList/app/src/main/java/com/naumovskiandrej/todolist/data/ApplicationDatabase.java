package com.naumovskiandrej.todolist.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {TodoItem.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    private static ApplicationDatabase instance;

    public ApplicationDatabase() {

    }

    public static ApplicationDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, ApplicationDatabase.class, "database")
                    .build();
        }
        return instance;
    }

    public abstract TodoItemDao todoItemDao();
}
