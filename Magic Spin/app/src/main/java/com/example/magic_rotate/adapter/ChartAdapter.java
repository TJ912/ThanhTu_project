package com.example.magic_rotate.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.magic_rotate.R;
import com.example.magic_rotate.data_local.User;

import java.util.List;

public class ChartAdapter  extends  RecyclerView.Adapter<ChartAdapter.MyViewHolder>{
    List<User> userList;
    LayoutInflater inflater;
    Context context;

    public ChartAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View view=inflater.from(context).inflate(R.layout.chart_adapter,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        String name=userList.get(position).getName();
        int point=userList.get(position).getPoint();
        int stt=userList.get(position).getNumber();

        //set Content

        viewHolder.tv_name.setText(name);
        viewHolder.tv_point.setText(String.valueOf(point));
        viewHolder.tv_stt.setText(String.valueOf(stt));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name,tv_stt,tv_point;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_chart_user);
            tv_stt=itemView.findViewById(R.id.tv_chart_stt);
            tv_point=itemView.findViewById(R.id.tv_chart_point);
        }
    }
}
