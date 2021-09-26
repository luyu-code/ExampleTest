package com.example.exampletest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.exampletest.R;

public class IncludeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_include);
        toolbar = findViewById(R.id.tool_include).findViewById(R.id.tool_bar);
        TextView textView = new TextView(this);
        textView.setText("我是Toolbar");
        toolbar.addView(textView);
        setSupportActionBar(toolbar);
    }
}