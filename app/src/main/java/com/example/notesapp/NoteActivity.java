package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.notesapp.MainActivity.adapter;
import static com.example.notesapp.MainActivity.modelClassList;

public class NoteActivity extends AppCompatActivity {

    public static EditText titleNote;
    public static EditText bodyNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        titleNote = findViewById(R.id.titleNote);
        bodyNote = findViewById(R.id.bodyNote);

        try {
            Bundle bundle = getIntent().getExtras();
            String title = bundle.getString("Title");
            String body = bundle.getString("Body");
            titleNote.setText(title);
            bodyNote.setText(body);
        } catch (Exception e) {
            Log.i("exception", e.getMessage());
        }

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton3);

        floatingActionButton.setOnClickListener(v -> {

            if (titleNote.getText().toString().trim().length() == 0 || bodyNote.getText().toString().trim().length() == 0) {
                Toast.makeText(NoteActivity.this, "Please add both title and description!", Toast.LENGTH_SHORT).show();
            } else {

                AppDatabase.getInstance(NoteActivity.this).noteDao().insertNote(new ModelClass(titleNote.getText().toString(), bodyNote.getText().toString()));

                Log.i("titlexx", titleNote.getText().toString());
                ModelClass modelClass = new ModelClass(titleNote.getText().toString(), bodyNote.getText().toString());
                modelClassList.add(modelClass);
                adapter.notifyDataSetChanged();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (titleNote.getText().toString().trim().length() == 0 || bodyNote.getText().toString().trim().length() == 0) {
            Toast.makeText(NoteActivity.this, "Please add both title and description!", Toast.LENGTH_SHORT).show();
        } else {
            AppDatabase.getInstance(NoteActivity.this).noteDao().insertNote(new ModelClass(titleNote.getText().toString(), bodyNote.getText().toString()));
            ModelClass modelClass = new ModelClass(titleNote.getText().toString(), bodyNote.getText().toString());
            modelClassList.add(modelClass);
            adapter.notifyDataSetChanged();
            finish();
        }
        super.onBackPressed();
    }
}