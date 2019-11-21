package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nhanhnhuchop_duan1.R;

public class Playscreen extends AppCompatActivity {
ImageView imgcancle, imgnext ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playscreen);
        imgcancle=findViewById(R.id.imgcancle);
        imgnext=findViewById(R.id.imgnext);

        imgcancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
