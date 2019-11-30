package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nhanhnhuchop_duan1.FastSqlite;
import com.example.nhanhnhuchop_duan1.R;
import com.example.nhanhnhuchop_duan1.model.User;

public class CreateAct extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtAgain;
    private Button btnLogin;

    private FastSqlite fastSqlite;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtAgain = (EditText) findViewById(R.id.edtAgain);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
                Toast.makeText(CreateAct.this, "Đăng kí Thành công", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void addUser(){
        User userModel = new User();

        userModel.setUsername(edtUsername.getText().toString());
        userModel.setPassword(edtPassword.getText().toString());

        FastSqlite nhasachDatabase = new FastSqlite(this);
        nhasachDatabase.themUser(userModel);
    }
}
