package com.example.nhanhnhuchop_duan1.Presenter;

import android.content.Context;

import com.example.nhanhnhuchop_duan1.FastSqlite;
import com.example.nhanhnhuchop_duan1.View.IDangKy;
import com.example.nhanhnhuchop_duan1.model.User;

public class DangKyPresenter {

    private Context  context;
    private IDangKy iDangKy;
    private FastSqlite fastSqlite;
    private User user;
    public DangKyPresenter(Context context, IDangKy iDangKy) {
        this.iDangKy = iDangKy;
        this.context = context;

    }

    public void checkDangKy(String name, String passWord, String repeatPass){
        if (name.isEmpty()){
            iDangKy.checkName();
        } else if (passWord.isEmpty()) {
            iDangKy.checkPass();
        }else if (repeatPass.isEmpty()){
            iDangKy.checkRepeat();
        }else if (!passWord.equals(repeatPass)){
            iDangKy.likePass();
        }else {
            user = new User();
            user.setUsername(name);
            user.setPassword(passWord);
            fastSqlite = new FastSqlite(context);
            Long id = fastSqlite.themUser(user);
            if (id >1){
                iDangKy.susse();
            }else {
                iDangKy.fail();
            }
        }


    }
}
