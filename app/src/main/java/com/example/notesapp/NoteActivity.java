package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static com.example.notesapp.MainActivity.adapter;
import static com.example.notesapp.MainActivity.modelClassList;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        EditText titleNote = findViewById(R.id.titleNote);
        EditText bodyNote = findViewById(R.id.bodyNote);

        ModelClass modelClass = new ModelClass(titleNote.getText().toString(), bodyNote.getText().toString());

        modelClassList.add(modelClass);

        adapter.notifyDataSetChanged();


    }
}