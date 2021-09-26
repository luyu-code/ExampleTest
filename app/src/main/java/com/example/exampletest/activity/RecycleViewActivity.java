package com.example.exampletest.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.exampletest.R;
import com.example.exampletest.adapter.MajorAdapter;
import com.example.exampletest.entity.Major;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity implements MajorAdapter.MajorItemClickListener {
    private RecyclerView recycle_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        recycle_view = findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycle_view.setLayoutManager(linearLayoutManager);
        ArrayList<Major> majorArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Major major = new Major("专业" + i);
            majorArrayList.add(major);
        }
        recycle_view.addItemDecoration(new MyDecoration());
        MajorAdapter majorAdapter = new MajorAdapter(majorArrayList,this);
        recycle_view.setAdapter(majorAdapter);
        majorAdapter.setMajorItemClickListener(this);
    }
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,1);
        }
    }


    @Override
    public void MajorItem(View view, int position) {
        Toast.makeText(this, position+"", Toast.LENGTH_SHORT).show();
    }
}