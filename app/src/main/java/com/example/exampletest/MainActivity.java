package com.example.exampletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.exampletest.entity.Student;
import com.example.exampletest.sqlite.StudentSQLiteDBHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private StudentSQLiteDBHelper studentSQLiteDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        ArrayList<Student> studentArrayList = new ArrayList<>();
//        //写入数据
//        Student student = new Student();
//        student.name="路宇";
//        student.grade="安卓一班";
//        student.major="Android";
//        student.age=20;
//        student.sex="男";
//        studentArrayList.add(student);
//        studentSQLiteDBHelper.insert(studentArrayList);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
////            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().setStatusBarColor(getResources().getColor(R.color.white));//设置状态栏颜色
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//实现状态栏图标和文字颜色为暗色
//        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


//        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.M){
//            //隐藏状态栏 但不隐藏状态栏字体
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            //隐藏状态栏并不显示字体
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            //实现状态栏字体文字颜色为暗色
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


    }

    @Override
    protected void onStart() {
        super.onStart();
        //创建数据库帮助器的唯一实例
        studentSQLiteDBHelper = StudentSQLiteDBHelper.getInstance(this, 1);
        //打开数据连接
        studentSQLiteDBHelper.openReadLink();

        ArrayList<Student> studentArrayList = new ArrayList<>();
        //写入数据
        Student student = new Student();
        student.name = "路宇";
        student.grade = "安卓一班";
        student.major = "Android";
        student.age = 20;
        student.sex = "男";
        studentArrayList.add(student);
        studentSQLiteDBHelper.insert(studentArrayList);
    }
}