package com.example.notesapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ModelClass {



    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "title")
    String titleRow;

    @ColumnInfo(name = "description")
    String descriptionRow;

    public void setTitleRow(String titleRow) {
        this.titleRow = titleRow;
    }

    public void setDescriptionRow(String descriptionRow) {
        this.descriptionRow = descriptionRow;
    }

    public ModelClass(String titleRow, String descriptionRow) {
        this.titleRow = titleRow;
        this.descriptionRow = descriptionRow;
    }

    public String getTitleRow() {
        return titleRow;
    }

    public String getDescriptionRow() {
        return descriptionRow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
