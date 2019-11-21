package com.example.nhanhnhuchop_duan1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhanhnhuchop_duan1.R;
import com.example.nhanhnhuchop_duan1.model.User;

import java.util.List;

public class TopAdapter extends RecyclerView.Adapter{
    List<User> userList;
    Context context;

    public TopAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user,parent,false);
        return new TopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class TopViewHolder extends RecyclerView.ViewHolder{
        public TextView tvUser;
        public TextView tvPoint;




        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = (TextView) itemView.findViewById(R.id.tvUser);
            tvPoint = (TextView) itemView.findViewById(R.id.tvPoint);
        }
    }
}
