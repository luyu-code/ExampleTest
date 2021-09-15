package com.example.exampletest.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.exampletest.R;

public class MaterialActivity extends AppCompatActivity implements View.OnClickListener {

    private Button my_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        my_toolbar = findViewById(R.id.my_toolbar);
        my_toolbar.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_toolbar:
                Intent intent = new Intent(this,ToolbarActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}