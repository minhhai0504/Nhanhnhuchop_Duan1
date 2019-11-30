package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhanhnhuchop_duan1.FastSqlite;
import com.example.nhanhnhuchop_duan1.R;

import java.util.concurrent.TimeUnit;

public class Playscreen extends AppCompatActivity {
    private TextView tvTime;
    private TextView tvDiem;
    private TextView tvQuestion;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;

    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_playscreen);
        tvDiem = (TextView) findViewById(R.id.tvDiem);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        tvTime = findViewById(R.id.tvTime);

        FastSqlite dbManager = new FastSqlite(this);
        dbManager.onOpen();

        Cursor cursor = dbManager.fetch();
        cursor.moveToFirst();
        final TextView studentName = (TextView) getActivity().findViewById(R.id.nameOfStudent);
        studentName.settext(cursor.getString(0));

        countDownTimer = new CountDownTimer(120000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTime.setText("" +millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(Playscreen.this, "Hết Giờ!!!!", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}

