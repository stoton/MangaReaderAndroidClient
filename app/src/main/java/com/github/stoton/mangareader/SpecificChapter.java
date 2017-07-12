package com.github.stoton.mangareader;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class SpecificChapter extends AppCompatActivity {
    private static String URL = "http://192.168.2.103:8080/backend/chapters/";
    private static String MANGA_ID = "mangaId";
    private static String CHAPTER_ID = "chapterId";
    private static String CHAPTER_END = "KONIEC ROZDZIAŁU";
    private static String FIRST_PAGE = "PIERWSZA STRONA";
    private static String JSON_ERROR = "Couldn't get json from server.";
    private List<String> pages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_specific_chapter);
        new MangaChapterDownloader().execute();
    }

    private class MangaChapterDownloader extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            int mangaId = getIntent().getExtras().getInt(MANGA_ID);
            int chapterId = getIntent().getExtras().getInt(CHAPTER_ID);

            String jsonStr = sh.makeServiceCall(URL + mangaId + "/" + chapterId);

            if (jsonStr != null) {
                try {
                    JSONArray mangaPages = new JSONArray(jsonStr);
                    for (int i = 0; i < mangaPages.length(); i++) {
                        String urls = mangaPages.getString(i);
                        pages.add(urls);
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
            final ImageView imageView = (ImageView) findViewById(R.id.imgManga);

            Picasso
                .with(SpecificChapter.this)
                .load(pages.get(0))
                .into(imageView);

            imageView.setOnTouchListener(new OnSwipeTouchListener(SpecificChapter.this) {
                int index = 0;
                int max = pages.size()-1;

                public void onSwipeLeft() {
                    if(index == max) {
                        Toast.makeText(SpecificChapter.this, CHAPTER_END, Toast.LENGTH_SHORT).show();
                    } else {
                        Picasso
                            .with(SpecificChapter.this)
                            .load(pages.get(index+1))
                            .into(imageView);
                        index++;
                    }
                }
                public void onSwipeRight() {
                    if(index == 0) {
                        Toast.makeText(SpecificChapter.this, FIRST_PAGE, Toast.LENGTH_SHORT).show();
                    } else {
                        Picasso
                            .with(SpecificChapter.this)
                            .load(pages.get(index-1))
                            .into(imageView);
                        index--;
                    }
                }
            });
        }
    }
}
