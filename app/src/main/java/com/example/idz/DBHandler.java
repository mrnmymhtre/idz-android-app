package com.example.idz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.Cursor;

import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;




public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "db";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "mynames";

    private static final String ID_COL = "id";

    private static final String NAME_COL = "name";

    private static final String EMAIL_COL = "email";

    private static final String DOB_COL = "dob";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + DOB_COL + " TEXT)";

        db.execSQL(query);
    }


    public void addNewEntry(String Name, String Email, String Dob) {


        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(NAME_COL, Name);
        values.put(EMAIL_COL, Email);
        values.put(DOB_COL, Dob);


        db.insert(TABLE_NAME, null, values);


        db.close();
    }


    public ArrayList<EntryModal> readEntry() {

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursorEntry = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);


        ArrayList<EntryModal> EntryModalArrayList = new ArrayList<>();

        if (cursorEntry.moveToFirst()) {
            do {
                EntryModalArrayList.add(new EntryModal(cursorEntry.getString(1),
                        cursorEntry.getString(4),
                        cursorEntry.getString(2),
                        cursorEntry.getString(3)));
            } while (cursorEntry.moveToNext());

        }
        cursorEntry.close();
        return EntryModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}


