package com.github.stoton.mangareader.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.json.JSONException;

public class MangaDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "mangaReader";
    private static final int DB_VERSION = 32;
    private static String DROP_TABLE_MANGA = "DROP TABLE IF EXISTS MANGA";
    private static String CREATE_TABLE_MANGA = "CREATE TABLE MANGA (_id INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, COVER TEXT);";

    public MangaDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DROP_TABLE_MANGA);
        db.execSQL(CREATE_TABLE_MANGA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            updateMyDatabase(db, 0, DB_VERSION);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) throws JSONException {
        db.execSQL(DROP_TABLE_MANGA);
        db.execSQL(CREATE_TABLE_MANGA);
    }
}

