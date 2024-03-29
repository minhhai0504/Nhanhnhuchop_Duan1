package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.nhanhnhuchop_duan1.FastSqlite;
import com.example.nhanhnhuchop_duan1.R;
import com.example.nhanhnhuchop_duan1.adapter.TopAdapter;
import com.example.nhanhnhuchop_duan1.model.User;

import java.util.List;

public class BXHactivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private List<User>  userList;

    private TopAdapter topAdapter;
    private FastSqlite fastSqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bxhactivity);
        recyclerView =  findViewById(R.id.recycleBXH);
        fastSqlite = new FastSqlite(this);
        userList = fastSqlite.userListTop();


        // sử dụng câu lệnh này nếu kích thước các hàng luôn
        // bằng nhau. việc này giúp list mượt hơn
        recyclerView.setHasFixedSize(true);

        // sử dụng LayoutManager để quy định kiểu hiển thị cho list là hàng dọc
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        topAdapter = new TopAdapter(userList,this);
        recyclerView.setAdapter(topAdapter);
    }
}
