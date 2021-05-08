package com.example.notesapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ModelClass.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();
    private static final Object LOCK = new Object();
    public static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context){

        if(appDatabase == null){
            synchronized (LOCK){
                appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, "modelclass")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return appDatabase;
    }

}
