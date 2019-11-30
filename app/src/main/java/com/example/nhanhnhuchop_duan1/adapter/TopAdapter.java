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

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.TopHolder> {
    List<User> userList;
    Context  context;

    public TopAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public TopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new TopHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopHolder holder, int position) {
        holder.tvUser.setText(userList.get(position).getUsername());
        holder.tvPoint.setText(String.valueOf(userList.get(position).getPoint()));

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class TopHolder extends RecyclerView.ViewHolder {
        private TextView tvUser;
        private TextView tvPoint;



        public TopHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = (TextView) itemView.findViewById(R.id.tvUser);
            tvPoint = (TextView) itemView.findViewById(R.id.tvPoint);
        }
    }
}
