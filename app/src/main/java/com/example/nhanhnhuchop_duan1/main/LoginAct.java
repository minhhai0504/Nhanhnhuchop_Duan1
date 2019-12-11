package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
import com.example.nhanhnhuchop_duan1.View.GetDataSql;
import com.example.nhanhnhuchop_duan1.View.CreateView;
import com.example.nhanhnhuchop_duan1.databinding.ActivityMenuBinding;

public class LoginAct extends AppCompatActivity implements GetDataSql {
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvRegister;
    private Boolean validUser;
    private ActivityMenuBinding binding;
    private String user;


    FastSqlite fastSqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_menu);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        fastSqlite = new FastSqlite(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 user = edtUsername.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();

                boolean s = fastSqlite.checkLogin(LoginAct.this,user, pass);





            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginAct.this, CreateAct.class));
                finish();
            }
        });

    }

    @Override
    public void saiTaiKhoan() {
        Toast.makeText(this, "saiTaiKhoan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saiMatKhau() {
        Toast.makeText(this, "saiMatKhau", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void trongTaiKhoan() {
        Toast.makeText(this, "trongTaiKhoan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void trongMatKhau() {
        Toast.makeText(this, "trongMatKhau", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void thanhCong() {
        Toast.makeText(this, "thanhCong", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginAct.this, MenuAct.class);
        Bundle bundle = new Bundle();
        bundle.putString("user", user);
        i.putExtras(bundle);
        startActivity(i);
    }
}
