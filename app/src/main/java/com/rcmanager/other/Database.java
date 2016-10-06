package com.rcmanager.other;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private DBHelper dbHelper;

    public Database(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Airplane airplane) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Airplane.KEY_name, airplane.getModelName());

        // Inserting Row
        long student_Id = db.insert(Airplane.tableName, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }

    public int insert(Battery battery) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Battery.KEY_brand, battery.getBrand());

        // Inserting Row
        long id = db.insert(Battery.tableName, null, values);
        db.close(); // Closing database connection
        return (int) id;
    }

    public void delete(Airplane airplane) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Airplane.tableName, Airplane.KEY_ID + "= ?", new String[]{String.valueOf(airplane.getID())});
        db.close(); // Closing database connection
    }

    public void delete(Battery battery) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Airplane.tableName, Airplane.KEY_ID + "= ?", new String[]{String.valueOf(battery.getID())});
        db.close(); // Closing database connection
    }

    public void update(Battery battery) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Battery.KEY_brand, battery.getBrand());

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Battery.tableName, values, Battery.KEY_ID + "= ?", new String[]{String.valueOf(battery.getID())});
        db.close(); // Closing database connection
    }

    public void update(Airplane airplane) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Battery.KEY_brand, airplane.getModelName());

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Battery.tableName, values, Battery.KEY_ID + "= ?", new String[]{String.valueOf(airplane.getID())});
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>> getAirplaneList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                Airplane.KEY_ID + "," +
                Airplane.KEY_name +
                " FROM " + Airplane.tableName;

        //Student student = new Student();
        ArrayList<HashMap<String, String>> studentList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> student = new HashMap<String, String>();
                student.put("id", cursor.getString(cursor.getColumnIndex(Airplane.KEY_ID)));
                student.put("name", cursor.getString(cursor.getColumnIndex(Airplane.KEY_name)));
                studentList.add(student);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;

    }

    public Airplane getAirplaneById(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                Airplane.KEY_ID + "," +
                Airplane.KEY_name +
                " FROM " + Airplane.tableName
                + " WHERE " +
                Airplane.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount = 0;
        Airplane airplane = new Airplane();

        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});

        if (cursor.moveToFirst()) {
            do {
                airplane.setID(cursor.getInt(cursor.getColumnIndex(Airplane.KEY_ID)));
                airplane.setModelName(cursor.getString(cursor.getColumnIndex(Airplane.KEY_name)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return airplane;
    }

}