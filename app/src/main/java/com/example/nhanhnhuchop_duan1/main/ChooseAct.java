package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.nhanhnhuchop_duan1.R;

public class ChooseAct extends AppCompatActivity {
    private Button btnLogin;
    private Button btnCreate;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCreate = (Button) findViewById(R.id.btnCreate);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseAct.this, Menu.class));
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseAct.this, CreateAct.class));
            }
        });
    }
}
