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
import com.example.nhanhnhuchop_duan1.Presenter.DangKyPresenter;
import com.example.nhanhnhuchop_duan1.R;
import com.example.nhanhnhuchop_duan1.View.IDangKy;

public class CreateAct extends AppCompatActivity implements IDangKy {
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtAgain;
    private Button btnLogin;

    private DangKyPresenter dangKyPresenter;
    private FastSqlite fastSqlite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create);
        dangKyPresenter = new DangKyPresenter(this,CreateAct.this);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtAgain = (EditText) findViewById(R.id.edtAgain);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = edtUsername.getText().toString();
                String passWord = edtPassword.getText().toString();
                String repeat = edtAgain.getText().toString();

                dangKyPresenter.checkDangKy(userName,passWord,repeat);

            }
        });
    }


    @Override
    public void checkName() {
        Toast.makeText(this, "Tài khoản không được để trống", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void checkPass() {
        Toast.makeText(this, "Mật khẩu không được để trống", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void checkRepeat() {
        Toast.makeText(this, "Bạn chưa nhập lại mật khẩu", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void likePass() {

        Toast.makeText(this, "Nhập lại mật khẩu không khớp", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void susse() {
        Toast.makeText(this, "Đăng kí thành công!!!!", Toast.LENGTH_SHORT).show();
        finish();

    }

    @Override
    public void fail() {

        Toast.makeText(this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
        finish();
    }
}
