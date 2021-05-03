package com.example.notesapp;

public class ModelClass {

    String titleRow, descriptionRow;

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
}
