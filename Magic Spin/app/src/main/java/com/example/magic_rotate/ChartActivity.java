package com.example.magic_rotate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.magic_rotate.adapter.ChartAdapter;
import com.example.magic_rotate.data_local.DataLocalManager;
import com.example.magic_rotate.data_local.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChartActivity extends AppCompatActivity {
    ImageView im_back;
    RecyclerView recyclerView;
    List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        init();
    }
    public void init(){
        userList= DataLocalManager.getListUser(ChartActivity.this);
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return (int) (u1.getPoint()-u2.getPoint());
            }
        });
        Collections.reverse(userList);
        int i=1;
        for(User u:userList){
            u.setNumber(i);
            i++;
            Log.d("user",""+u.getNumber()+u.getName()+u.getPoint());
        }

        im_back=findViewById(R.id.imv_back);
        recyclerView=findViewById(R.id.recyclerview);


        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ChartAdapter adapter=new ChartAdapter(userList,ChartActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(10);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ChartActivity.this,LinearLayoutManager.VERTICAL,false));

    }
}