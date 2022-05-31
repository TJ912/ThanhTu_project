package com.example.musicbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class ChatActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView mMessageRV;
    TextView mName,mState;
    EditText mMessEdt;
    ImageView mSendIm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        init();
    }
    public void init(){
        toolbar=findViewById(R.id.toolbar);

        toolbar.setTitle("");


        mMessageRV=findViewById(R.id.mess_rv);
        mName=findViewById(R.id.mess_name_tv);
        mState=findViewById(R.id.mess_state_tv);
        mSendIm=findViewById(R.id.mess_send_imv);
        mMessEdt=findViewById(R.id.message_edt);
    }


}