package com.example.musicapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Songadapter extends BaseAdapter {
    Context context;
    ArrayList<Song> list=new ArrayList<>();
    LayoutInflater inflater;

    public Songadapter(Context context, ArrayList<Song> list) {
        this.context = context;
        this.list = list;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=inflater.inflate(R.layout.activity_song_adapter,parent,false);
        }
        ImageView imageView=(ImageView)convertView.findViewById(R.id.image);
        TextView singer=(TextView)convertView.findViewById(R.id.tv_singer);
        TextView songname=(TextView)convertView.findViewById(R.id.tv_songname);

        Picasso.get().load(list.get(position).getPicture()).resize(80,80).centerCrop().into(imageView);
        singer.setText(list.get(position).getSinger());
        songname.setText((list).get(position).getName());

        return convertView;
    }
}