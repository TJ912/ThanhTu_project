package com.example.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Song> list=new ArrayList<>();
    Songadapter adapter;
    Data data=new Data();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
        setContentView(R.layout.activity_main);

        init();



    }
    public void init(){
        listView=findViewById(R.id.lv_playlist);

        Collections.addAll(list, data.songs);

        adapter=new Songadapter(MainActivity.this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent=new Intent(MainActivity.this,play.class); //chuyen activity
            intent.putExtra("id",position);
            Log.d("vi tri truyen",String.valueOf(position));
            startActivity(intent);
        });
    }
}