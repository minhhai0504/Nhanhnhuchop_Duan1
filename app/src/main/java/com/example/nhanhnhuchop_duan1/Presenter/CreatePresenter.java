package com.example.nhanhnhuchop_duan1.Presenter;

import com.example.nhanhnhuchop_duan1.FastSqlite;
import com.example.nhanhnhuchop_duan1.View.CreateView;

public class CreatePresenter {
    FastSqlite fastSqlite;
    CreateView loginView;

    public CreatePresenter(FastSqlite fastSqlite, CreateView loginView) {
        this.fastSqlite = fastSqlite;
        this.loginView = loginView;
    }

    public void login(String username, String password){
        if (username.isEmpty()) {
            loginView.setErrorUsernameCreate();
            return;
        } else if (password.isEmpty()) {
            loginView.setErrorPasswordCreate();
            return;
        } else {
            // giả sử tk là admin với mật khẩu là admin nhé :D
            if (username.equalsIgnoreCase("admin")
                    && password.
                    equalsIgnoreCase("admin")) {
                loginView.loginSuccessful();
                loginView.navigateHome();
            } else {
                loginView.loginFail();
            }
        }
    }
}
