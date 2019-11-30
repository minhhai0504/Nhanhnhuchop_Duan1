package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.nhanhnhuchop_duan1.R;

public class MenuAct extends AppCompatActivity {
    private Button btnPlay;
    private Button btnBXH;
    private Button btnThoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chon);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnBXH = (Button) findViewById(R.id.btnBXH);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        Bundle bundle  = getIntent().getExtras();
        final String user  = bundle.getString("user");

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MenuAct.this,Playscreen.class));
                Intent intent = new Intent(MenuAct.this,Playscreen.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("user",user);
                intent.putExtras(bundle1);
                startActivity(intent);


            }
        });

        btnBXH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuAct.this,BXHactivity.class));
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(MenuAct.this, LoginAct.class));

            }
        });
    }
}
