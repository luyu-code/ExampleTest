package com.example.exampletest.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.exampletest.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FruitActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsing;
    private Toolbar toolbar;
    private FloatingActionButton floating;
    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        collapsing = findViewById(R.id.collapsing);
        toolbar = findViewById(R.id.toolbar);
        floating = findViewById(R.id.floating);
        tv_text = findViewById(R.id.tv_text);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsing.setTitle("这是CollapsingToolbarLayout");
        String text = "努力努力再努力";

        tv_text.setText(generateText(text));
        floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FruitActivity.this, "您点击了悬浮按钮哦！", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String generateText(String text) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 500; i++) {
            stringBuilder.append(text);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //Toolbar左上角默认有一个返回的箭头，含义是返回上一个活动
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}