package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.nhanhnhuchop_duan1.R;

public class ChonAct extends AppCompatActivity {
    private Button btnLogin;
    private Button btnBXH;
    private Button btnThoat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chon);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnBXH = (Button) findViewById(R.id.btnBXH);
        btnThoat = (Button) findViewById(R.id.btnThoat);

        btnBXH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChonAct.this,BXHactivity.class));
            }
        });
    }
}
