package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhanhnhuchop_duan1.FastSqlite;
import com.example.nhanhnhuchop_duan1.R;

public class LoginAct extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private Boolean validUser;


    FastSqlite fastSqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        fastSqlite = new FastSqlite(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUsername.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();

                boolean s = fastSqlite.checkLogin(user, pass);


                if (s) {
                    Intent i = new Intent(LoginAct.this, MenuAct.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("user", user);
                    i.putExtras(bundle);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginAct.this, "Sai Thông Tin Đăng Nhập", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginAct.this, CreateAct.class));
            }
        });

    }
}
