package com.example.nhanhnhuchop_duan1.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
import com.example.nhanhnhuchop_duan1.model.Question;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Playscreen extends AppCompatActivity {
    private TextView tvTime;
    private TextView tvDiem;
    private TextView tvQuestion;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private List<Question> questionList;
    private FastSqlite fastSqlite;
    private int dem = 1;
    private int point = 10;
    private int point1 = 0;
    private String user;
    private Playscreen playscreen;

    private String valueTrue;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_playscreen);
        fastSqlite = new FastSqlite(this);
        Bundle bundle = getIntent().getExtras();
        user = bundle.getString("user");
        tvDiem = (TextView) findViewById(R.id.tvDiem);
        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        tvTime = findViewById(R.id.tvTime);


        Question question = new Question();
        question = fastSqlite.getQurstion("Q" + dem);
        tvQuestion.setText(question.getQuestion());
        btnA.setText(question.getA());
        btnB.setText(question.getB());
        btnC.setText(question.getC());
        btnD.setText(question.getD());
        valueTrue = question.getTrue();

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = btnA.getText().toString();

                if (buttonText.equalsIgnoreCase(valueTrue)) {
                    dem++;

                    point1 += point;
                    tvDiem.setText(String.valueOf(point1));
                    fastSqlite.updaptePoint(user, String.valueOf(point1));
                    tvQuestion.setText("");
                    btnA.setText("");
                    btnB.setText("");
                    btnC.setText("");
                    btnD.setText("");

                    Question question = new Question();
                    question = fastSqlite.getQurstion("Q" + dem);

                    tvQuestion.setText(question.getQuestion());
                    btnA.setText(question.getA().trim());
                    btnB.setText(question.getB().trim());
                    btnC.setText(question.getC().trim());
                    btnD.setText(question.getD().trim());
                    valueTrue = question.getTrue();
                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Playscreen.this);

                    builder.setTitle("Sai Rồi!!!");

                    builder.setMessage("Bạn muốn chơi lại?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = btnB.getText().toString();


                if (buttonText.equalsIgnoreCase(valueTrue)) {
                    dem++;
                    point1 += point;
                    tvDiem.setText(String.valueOf(point1));
                    fastSqlite.updaptePoint(user, String.valueOf(point1));
                    tvQuestion.setText("");
                    btnA.setText("");
                    btnB.setText("");
                    btnC.setText("");
                    btnD.setText("");

                    Question question = new Question();
                    question = fastSqlite.getQurstion("Q" + dem);
                    tvQuestion.setText(question.getQuestion());
                    btnA.setText(question.getA().trim());
                    btnB.setText(question.getB().trim());
                    btnC.setText(question.getC().trim());
                    btnD.setText(question.getD().trim());
                    valueTrue = question.getTrue();


                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Playscreen.this);

                    builder.setTitle("Sai Rồi!!!");

                    builder.setMessage("Bạn muốn chơi lại?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }


            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = btnC.getText().toString();


                if (buttonText.equalsIgnoreCase(valueTrue)) {
                    point1 += point;
                    tvDiem.setText(String.valueOf(point1));
                    fastSqlite.updaptePoint(user, String.valueOf(point1));
                    dem++;
                    tvQuestion.setText("");
                    btnA.setText("");
                    btnB.setText("");
                    btnC.setText("");
                    btnD.setText("");

                    Question question = new Question();
                    question = fastSqlite.getQurstion("Q" + dem);
                    tvQuestion.setText(question.getQuestion());
                    btnA.setText(question.getA().trim());
                    btnB.setText(question.getB().trim());
                    btnC.setText(question.getC().trim());
                    btnD.setText(question.getD().trim());
                    valueTrue = question.getTrue();

                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Playscreen.this);

                    builder.setTitle("Sai Rồi!!!");

                    builder.setMessage("Bạn muốn chơi lại?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }


            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonText = btnD.getText().toString();


                if (buttonText.equalsIgnoreCase(valueTrue)) {
                    point1 += point;
                    tvDiem.setText(String.valueOf(point1));
                    fastSqlite.updaptePoint(user, String.valueOf(point1));
                    dem++;
                    tvQuestion.setText("");
                    btnA.setText("");
                    btnB.setText("");
                    btnC.setText("");
                    btnD.setText("");

                    Question question = new Question();
                    question = fastSqlite.getQurstion("Q" + dem);
                    tvQuestion.setText(question.getQuestion());
                    btnA.setText(question.getA().trim());
                    btnB.setText(question.getB().trim());
                    btnC.setText(question.getC().trim());
                    btnD.setText(question.getD().trim());
                    valueTrue = question.getTrue();

                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(Playscreen.this);

                    builder.setTitle("Sai Rồi!!!");

                    builder.setMessage("Bạn muốn chơi lại?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }


            }
        });


        countDownTimer = new CountDownTimer(120000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTime.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Playscreen.this);

                builder.setTitle("Hết Giờ");

                builder.setMessage("Bạn muốn chơi lại?");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        }.start();
    }



    private void getQuestion() {

        Question question = new Question();
        question = fastSqlite.getQurstion("Q1");
        tvQuestion.setText(question.getQuestion());
        btnA.setText(question.getA());
        btnB.setText(question.getB());
        btnC.setText(question.getC());
        btnD.setText(question.getD());
        valueTrue = question.getTrue();


    }

}