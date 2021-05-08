package com.example.notesapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM modelclass")
    List<ModelClass> getAllNotes();

    @Insert
    void insertAll(ModelClass modelClasses);

    @Delete
    void delete(ModelClass modelClass);

}
