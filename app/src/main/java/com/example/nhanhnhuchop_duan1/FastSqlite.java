package com.example.nhanhnhuchop_duan1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.nhanhnhuchop_duan1.main.DataSingIn;
import com.example.nhanhnhuchop_duan1.model.Question;
import com.example.nhanhnhuchop_duan1.model.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

import static android.provider.Telephony.Carriers.PASSWORD;

public class FastSqlite extends SQLiteOpenHelper {
    private static String DB_PATH = "";
    private static String DB_NAME = "Fast.db";
    private Context context;
    SQLiteDatabase sqLiteDatabase;


    public String IdUser = "ID";
    public String username = "USERNAME";
    public String password = "PASSWORD";
    public String Point = "POINT";


    public String Id = "ID";
    public String Question = "QUESTION";
    public String A = "A";
    public String B = "B";
    public String C = "C";
    public String D = "D";
    public String True = "TRUE";


    public FastSqlite(@Nullable Context context) {
        super(context, DB_NAME, null, 1);

        this.context = context;

        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
    }

    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e("abc", "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    private void copyDataBase() throws IOException {
        InputStream mInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public long themUser(User userModel) {


        // xin quyen
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        // ghep cap ten cot vs gia tri
        ContentValues contentValues = new ContentValues();
        contentValues.put(IdUser, userModel.getID());
        contentValues.put(username, userModel.getUsername());
        contentValues.put(password, userModel.getPassword());
        contentValues.put(Point, userModel.getPoint());


        long id = sqLiteDatabase.insert("USER",
                null, contentValues);


        sqLiteDatabase.close();
        return id;

    }

    public List<Question> listQuestion() {

        List<Question> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT * FROM QUESTION";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Question question = new Question();
                    question.Id = cursor.getString(cursor.getColumnIndex(Id));
                    question.Question = cursor.getString(cursor.getColumnIndex(Question));
                    question.A = cursor.getString(cursor.getColumnIndex(A));
                    question.B = cursor.getString(cursor.getColumnIndex(B));
                    question.C = cursor.getString(cursor.getColumnIndex(C));
                    question.D = cursor.getString(cursor.getColumnIndex(D));
                    question.True = cursor.getString(cursor.getColumnIndex(True));


                    list.add(question);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return list;
    }

    public List<User> ListBXH() {

        List<User> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT * FROM USER ORDER BY POINT DESC";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    User user = new User();
                    user.ID = cursor.getString(cursor.getColumnIndex(IdUser));
                    user.username = cursor.getString(cursor.getColumnIndex(username));
                    user.password = cursor.getString(cursor.getColumnIndex(password));
                    user.point = Integer.parseInt(cursor.getString(cursor.getColumnIndex(Point)));


                    list.add(user);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return list;
    }

    public boolean checkLogin(String name, String pass) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM USER WHERE USERNAME = \"" + name + "\"" + "AND PASSWORD =\"" + pass + "\"", null);


        if (c.getCount() == 1) {
            c.close();
            db.close();
            return true;
        } else {
            c.close();
            db.close();
            return false;
        }
    }



    public List<User> userListTop() {

        List<User> list = new ArrayList<>();
         sqLiteDatabase = this.getReadableDatabase();
        String SQL = "SELECT * FROM USER ORDER BY POINT DESC  LIMIT 5 ";
        Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
        cursor.moveToFirst();

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    User user = new User();
                    user.ID = cursor.getString(cursor.getColumnIndex(IdUser));
                    user.username = cursor.getString(cursor.getColumnIndex(username));
                    user.password = cursor.getString(cursor.getColumnIndex(password));
                    user.point = Integer.parseInt(cursor.getString(cursor.getColumnIndex(Point)));

                    list.add(user);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return list;
    }

    public int updaptePoint(String username, String point) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", username);
        contentValues.put("point", point);

        return sqLiteDatabase.update("USER", contentValues, "USERNAME" + " = ?",
                new String[]{username});

    }

    public Question getQurstion(String id) {
        Question question = new Question();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM QUESTION WHERE ID= " + "\"" + id + "\"";
        Cursor cursor = db.rawQuery(select, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    question.Question = cursor.getString(cursor.getColumnIndex("QUESTION"));
                    question.Id = cursor.getString(cursor.getColumnIndex("ID"));
                    question.A = cursor.getString(cursor.getColumnIndex("A"));
                    question.B = cursor.getString(cursor.getColumnIndex("B"));
                    question.C = cursor.getString(cursor.getColumnIndex("C"));
                    question.D = cursor.getString(cursor.getColumnIndex("D"));
                    question.True = cursor.getString(cursor.getColumnIndex("TRUE"));
                    cursor.moveToNext();
                    return question;
                }
                cursor.close();
            }
        }

        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
