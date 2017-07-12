package com.github.stoton.mangareader;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final String[] image;
    public CustomList(Activity context,
                      String[] title, String[] image) {
        super(context, R.layout.activity_manga_cover, title);
        this.context = context;
        this.web = title;
        this.image = image;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_manga_cover, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);

        Picasso
             .with(context)
             .load(image[position])
             .into(imageView);
        return rowView;
    }
}
