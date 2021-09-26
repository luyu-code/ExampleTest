package com.example.exampletest.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.exampletest.R;

public class ProgressActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar my_progress;
    private Button btn_action;
    private int Length=100;
    private int i;//定义起始进度条的进度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        my_progress = findViewById(R.id.my_progress);
        btn_action = findViewById(R.id.btn_action);
        btn_action.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //启动进度条
        handler.sendEmptyMessage(1);
    }
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if (msg.what==1){

                if (Length-i>0){
                  i++;
                  my_progress.setProgress(i);
                  handler.sendEmptyMessageDelayed(1,1000);
                } else {
                    Toast.makeText(ProgressActivity.this, "完成！", Toast.LENGTH_SHORT).show();
                }
            }
            return false;
        }
    });
}