package com.github.stoton.mangareader;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.ListActivity;
import android.os.AsyncTask;

import android.os.Bundle;

import android.widget.ArrayAdapter;

import com.github.stoton.mangareader.domain.MangaChapter;

import java.util.ArrayList;
import java.util.List;

public class SpecificMangaChapters extends ListActivity {
    private static String URL = "http://192.168.2.103:8080/backend/chapters/";
    private static String JSON_ERROR = "Couldn't get json from server.";
    private static String TITLE = "title";
    private static String MANGA_ID = "mangaId";
    private static String CHAPTER_ID = "chapterId";
    private static String ID = "id";
    private static String MANGA_LENGTH = "length";
    private static String MANGA_NUMBER = "number";
    private int[] ids;
    private List<MangaChapter> mangaChapterList = new ArrayList<>();
    private int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MangaChapterDownloader().execute();

        String title = (String) getIntent().getExtras().get(TITLE);
        TextView textView = (TextView) findViewById(R.id.text2);
        if(textView != null)
        textView.setText(title);
    }

    @Override
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Intent intent = new Intent(this, SpecificChapter.class);
        intent.putExtra(MANGA_ID, (Integer) getIntent().getExtras().get(ID));
        intent.putExtra(CHAPTER_ID, ids[position]);
        startActivity(intent);
    }

    private class MangaChapterDownloader extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler httpHandler = new HttpHandler();
            int mangaChapterId = getIntent().getExtras().getInt(ID);
            String url = URL + mangaChapterId;
            String jsonStr = httpHandler.makeServiceCall(url);


            if (jsonStr != null) {
                try {
                    JSONArray mangaChapters = new JSONArray(jsonStr);
                    for (int i = 0; i < mangaChapters.length(); i++) {
                        JSONObject object = mangaChapters.getJSONObject(i);
                        long id = object.getLong(CHAPTER_ID);
                        long length = object.getLong(MANGA_LENGTH);
                        long number = object.getLong(MANGA_NUMBER);

                        MangaChapter mangaChapter = new MangaChapter(id, url, length, number);
                        mangaChapterList.add(mangaChapter);
                    }
                    size = mangaChapterList.size();
                } catch (final JSONException e) {
                    Log.e(HttpHandler.TAG, JSON_ERROR);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    JSON_ERROR,
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
            else {
                Log.e(HttpHandler.TAG, JSON_ERROR);
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
            String[] list = new String[size];
            ids = new int[size];
            for(int i = 1; i <= size; i++) {
                list[i-1] = "CHAPTER " + i;
                ids[i-1] = i;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(SpecificMangaChapters.this,
                    android.R.layout.simple_list_item_1, list);
            setListAdapter(adapter);
        }
    }
}