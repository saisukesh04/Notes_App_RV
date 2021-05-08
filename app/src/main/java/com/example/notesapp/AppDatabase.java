package com.example.notesapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ModelClass.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

}
