package com.example.exampletest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exampletest.R;
import com.example.exampletest.entity.Major;

import java.util.ArrayList;

public class MajorAdapter extends RecyclerView.Adapter<MajorAdapter.ViewHolder> {
    private ArrayList<Major> majorArrayList;
    private Context context;

    public MajorAdapter(ArrayList<Major> majorArrayList, Context context) {
        this.majorArrayList = majorArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MajorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_major, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MajorAdapter.ViewHolder holder, int position) {
        Major major = majorArrayList.get(position);
        holder.tv_major.setText(major.specific);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
//                Toast.makeText(context, "您点击了第" + position + "行！", Toast.LENGTH_SHORT).show();

                majorItemClickListener.MajorItem(holder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return majorArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_major;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_major = itemView.findViewById(R.id.tv_major);
        }

    }

    //声明点击监听器
    public MajorItemClickListener majorItemClickListener;
    //设置跳转监听器

    public void setMajorItemClickListener(MajorItemClickListener majorItemClickListener) {
        this.majorItemClickListener = majorItemClickListener;
    }

    //声明点击监听器的接口
    public interface MajorItemClickListener {
        void MajorItem(View view, int position);

    }


}
