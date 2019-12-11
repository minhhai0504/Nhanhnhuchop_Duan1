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
import com.example.nhanhnhuchop_duan1.Presenter.CreatePresenter;
import com.example.nhanhnhuchop_duan1.R;
import com.example.nhanhnhuchop_duan1.View.CreateView;
import com.example.nhanhnhuchop_duan1.model.User;

public class CreateAct extends AppCompatActivity implements CreateView, View.OnClickListener {
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtAgain;
    private Button btnLogin;
    CreatePresenter createPresenter;

    private FastSqlite fastSqlite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtAgain = (EditText) findViewById(R.id.edtAgain);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }







    @Override
    public void CreateFail() {
        Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void CreateSuccessful() {
        Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void CHuyenmanhinh() {
        addUser();

    }

    @Override
    public void setErrorUsernameCreate() {
        Toast.makeText(this, "Bạn chưa nhập tài khoản", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setErrorPasswordCreate() {
        Toast.makeText(this, "Bạn chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            createPresenter.login(username, password);

        }
    }
    public void addUser() {
        User userModel = new User();

        userModel.setUsername(edtUsername.getText().toString());
        userModel.setPassword(edtPassword.getText().toString());

        FastSqlite nhasachDatabase = new FastSqlite(this);
        nhasachDatabase.themUser(userModel);
    }
}
