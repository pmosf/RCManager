package com.rcmanager.other;

public class Airplane {
    public static final String tableName = "Airplane";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";

    private int ID;
    private String modelName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
