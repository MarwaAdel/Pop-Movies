package com.example.marwaadel.test1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Marwa Adel on 12/25/2015.
 */
public class ImageAdapter extends BaseAdapter{


     Context mcontext;
     LayoutInflater inflater;
     ArrayList<String> movie;

    public ImageAdapter(Context mcontext, ArrayList<String> movie) {
        this.mcontext = mcontext;
        this.movie = movie;
        inflater=(LayoutInflater)mcontext.getSystemService(mcontext.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return movie.size();
    }

    @Override
    public String getItem(int position) {
        return movie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


            String url =movie.get(position);
            ImageView poster;

        if(convertView==null) {
            convertView = inflater.inflate(R.layout.movieitem, null);
        }

        poster= (ImageView)convertView.findViewById(R.id.imageview);
        poster.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(mcontext).load(url).fit().into(poster);
        Log.e("urls", url);


        return convertView;
    }

}
