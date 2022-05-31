package com.example.magic_rotate.data_local;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class MySharePreferences {
    private static final  String MY_SHARED_REFERENCES="MY_SHARED_REFERENCES";
    private Context mContext;

    public MySharePreferences(Context context){this.mContext=context;}
    public MySharePreferences(){}

    public void putStringValue(String key,String value){
       SharedPreferences sharedPreferences=mContext.getSharedPreferences(MY_SHARED_REFERENCES,Context.MODE_PRIVATE);
       SharedPreferences.Editor editor= sharedPreferences.edit();
       editor.putString(key,value);
       editor.apply();
        Log.d("Save", "Da save");


    }
    public String getStringValue(String key){
        SharedPreferences sharedPreferences=mContext.getSharedPreferences(MY_SHARED_REFERENCES,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }

}
