package com.example.magic_rotate.data_local;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.magic_rotate.ChartActivity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataLocalManager {

    private static final String PREF_OBJECT_USER = "PREF_OBJECT_USER";
    private static final String PRE_LIST_USER = "PRE_LIST_USER";
    private static DataLocalManager instance;
    private MySharePreferences mySharePreferences;

    public static void init(Context context) {
        instance = new DataLocalManager();
        instance.mySharePreferences = new MySharePreferences(context);
    }

    public static DataLocalManager getInstance(Context mContext) {
        if (instance == null) {
            instance = new DataLocalManager();
            instance.mySharePreferences=new MySharePreferences(mContext);
        }
        return instance;
    }

//    public static void setUser(User user) {
//        Gson gson = new Gson();
//        String strJsUser = gson.toJson(user);
//        DataLocalManager.getInstance().mySharePreferences.putStringValue(PREF_OBJECT_USER, strJsUser);
//    }

//    public static User getUser() {
//        String strJsonUser = DataLocalManager.getInstance().mySharePreferences.getStringValue(PREF_OBJECT_USER);
//        Gson gson = new Gson();
//        User user = gson.fromJson(strJsonUser, User.class);
//        return user;
//    }

    public static void setListUser(List<User> listUser,Context context) {
        Gson gson = new Gson();
        JsonArray jsonArray = gson.toJsonTree(listUser).getAsJsonArray();
        String strJsonArray = jsonArray.toString();
        Log.d("strJson",""+strJsonArray);
        DataLocalManager.getInstance(context).mySharePreferences.putStringValue(PRE_LIST_USER,strJsonArray);
    }

    public static List<User> getListUser(Context context) {
        List<User> list = new ArrayList<>();
        String stJsonArray = DataLocalManager.getInstance(context).mySharePreferences.getStringValue(PRE_LIST_USER);

//        if(stJsonArray.isEmpty()){
//            list.add(new User("Player1",100));
//            list.add(new User("Player2",200));
//            list.add(new User("Player3",5000));
//        }else{
            try {
                JSONArray jsonArray = new JSONArray(stJsonArray);
                JSONObject jsonObject;
                User user;
                Gson gson = new Gson();
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    user = gson.fromJson(jsonObject.toString(), User.class);
                    list.add(user);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
      //  }


        return list;
    }
}
