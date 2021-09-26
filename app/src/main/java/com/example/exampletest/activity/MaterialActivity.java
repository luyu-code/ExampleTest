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
    private Button my_progress;
    private Button my_Coordinator;
    private Button my_include;
    private Button btn_file_store;
    private Button btn_recycle_view;
    private Button btn_broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        my_toolbar = findViewById(R.id.my_toolbar);
        my_toolbar.setOnClickListener(this);
        my_progress = findViewById(R.id.my_progress);
        my_progress.setOnClickListener(this);
        my_Coordinator = findViewById(R.id.my_Coordinator);
        my_Coordinator.setOnClickListener(this);
        my_include = findViewById(R.id.my_include);
        my_include.setOnClickListener(this);
        btn_file_store = findViewById(R.id.btn_file_store);
        btn_file_store.setOnClickListener(this);
        btn_recycle_view = findViewById(R.id.btn_recycle_view);
        btn_recycle_view.setOnClickListener(this);
        btn_broadcastReceiver = findViewById(R.id.btn_broadcastReceiver);
        btn_broadcastReceiver.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.my_toolbar:
                intent = new Intent(this,ToolbarActivity.class);
                break;
            case R.id.my_progress:
                intent = new Intent(this,ProgressActivity.class);
                break;
            case R.id.my_Coordinator:
                intent = new Intent(this,FruitActivity.class);
                break;
            case R.id.my_include:
                intent = new Intent(this,IncludeActivity.class);
                break;
            case R.id.btn_file_store:
                intent = new Intent(this,FileStoreActivity.class);
                break;
            case R.id.btn_recycle_view:
                intent = new Intent(this,RecycleViewActivity.class);
                break;
            case R.id.btn_broadcastReceiver:
                intent = new Intent(this,BroadCastReceiverActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}