package com.github.stoton.mangareader;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.stoton.mangareader.repository.MangaDatabaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {
    private static String URL = "http://192.168.2.103:8080/backend/manga/all";
    private static String JSON_ERROR = "Couldn't get json from server.";
    private static String CREATE_TABLE_MANGA = "CREATE TABLE MANGA (_id INTEGER PRIMARY KEY AUTOINCREMENT,  TITLE TEXT, COVER TEXT)";
    private static String DROP_TABLE_MANGA = "DROP TABLE IF EXISTS MANGA";
    private static String MANGA = "MANGA";
    private static String TITLE = "title";
    private static String IMAGE_URL = "imageUrl";
    private static String COVER = "COVER";
    private static String MANGA_ID = "_id";
    private static String ID = "id";
    private SQLiteDatabase db;
    private ListView list;
    private int[] ids;
    private String[] image;
    private String[] title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        SQLiteOpenHelper mangaDatabaseHelper = new MangaDatabaseHelper(this);
        db = mangaDatabaseHelper.getWritableDatabase();

        new GetContacts().execute();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler httpHandler =  new HttpHandler();
            String jsonStr = httpHandler.makeServiceCall(URL);

            if (jsonStr != null) {
                try {
                    JSONArray manga = new JSONArray(jsonStr);

                    db.execSQL(DROP_TABLE_MANGA);
                    db.execSQL(CREATE_TABLE_MANGA);

                    for (int i = 0; i < manga.length(); i++) {
                        JSONObject c = manga.getJSONObject(i);
                        String title = c.getString(TITLE);
                        String imageUrl = c.getString(IMAGE_URL);

                        ContentValues mangaValues = new ContentValues();
                        mangaValues.put(TITLE, title);
                        mangaValues.put(COVER, imageUrl);
                        db.insert(MANGA, null, mangaValues);

                    }
                } catch (final JSONException e) {
                    Log.e(HttpHandler.TAG, e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }

            } else {
                Log.e(HttpHandler.TAG, DROP_TABLE_MANGA);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                JSON_ERROR,
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Cursor cursor = db.query(MANGA,
                    new String[]{MANGA_ID, TITLE, COVER},
                    null, null, null, null, null
            );

            int columnCount = 46;
            image = new String[columnCount];
            title = new String[columnCount];
            ids = new int[columnCount];

            if(cursor.moveToFirst()) {
                int index = 0;
                do {
                    ids[index] = cursor.getInt(0);
                    title[index] = cursor.getString(1);
                    image[index] = cursor.getString(2);
                    index++;
                } while (cursor.moveToNext());
            }

            CustomList adapter = new
                    CustomList(MainActivity.this, title, image);
            list = (ListView) findViewById(R.id.list);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Intent intent = new Intent(MainActivity.this, SpecificMangaChapters.class);
                    intent.putExtra(ID, ids[position]);
                    intent.putExtra(TITLE, title[position]);
                    startActivity(intent);
                }
            });
            cursor.close();
            db.close();
        }
    }
}