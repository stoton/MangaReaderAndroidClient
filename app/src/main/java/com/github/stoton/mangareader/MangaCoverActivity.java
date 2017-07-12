package com.github.stoton.mangareader;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.github.stoton.mangareader.domain.Manga;
import com.github.stoton.mangareader.repository.MangaDatabaseHelper;


public class MangaCoverActivity extends ListActivity {
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView mangaList = getListView();

        try {
            SQLiteOpenHelper mangaDatabaseHelper = new MangaDatabaseHelper(this);
            db = mangaDatabaseHelper.getReadableDatabase();

            cursor = db.query("MANGA",
                    new String[]{"_id", "TITLE, COVER"},
                    null, null, null, null, null
            );
            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"TITLE"},
                    new int[]{android.R.id.text1},
                    0);

            mangaList.setAdapter(listAdapter);

        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {

        ListAdapter listAdapter = listView.getAdapter();
        Cursor cursor = (Cursor) listAdapter.getItem(position);
        int columnIndex = cursor.getColumnIndex("COVER");
        String title = cursor.getString(columnIndex);
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
    }
}
