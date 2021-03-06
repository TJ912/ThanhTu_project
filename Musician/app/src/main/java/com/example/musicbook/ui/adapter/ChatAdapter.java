package com.example.musicbook.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicbook.ChatActivity;
import com.example.musicbook.R;
import com.example.musicbook.ui.model.User;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder>{
    List<User> users;
    LayoutInflater layoutInflater;
    Context context;

    public ChatAdapter(List<User> users, Context context) {
       this.context=context;
        this.users = users;
    }




    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //inflate layout(row_user.xml)
        View view =LayoutInflater.from(context).inflate(R.layout.row_users,parent,false);

        //init recyclerview



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ChatAdapter.MyViewHolder holder, int position) {
       //get data
        String userUID=users.get(position).getUid();
        String userImage=users.get(position).getImage();
        String userName=users.get(position).getName();
        String userLocation=users.get(position).getLocation();

        //set data
        holder.mNameTv.setText(userName);
        holder.mRecentChatTv.setText(userLocation);
        try {
            Picasso.get().load(userImage).placeholder(R.drawable.blankavatar).into(holder.mAvatarIv);
        }
            catch(Exception e){

        }
        //handle item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ChatActivity.class);

                intent.putExtra("hisUID",userUID);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mAvatarIv;
        TextView mNameTv,mRecentChatTv;
        public MyViewHolder(@NonNull View view) {
            super(view);

            //init views
            mAvatarIv=view.findViewById(R.id.avatar_img_adapter_user);
            mNameTv=view.findViewById(R.id.name_tv_adapter_user);
            mRecentChatTv=view.findViewById(R.id.location_tv_adapter_user);

        }


    }
}
