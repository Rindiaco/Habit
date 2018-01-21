package com.rindia.habit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.rindia.habit.bean.Habit;

import java.util.List;

/**
 * Created by 汪磊 on 2018/1/17.
 */

public class DisplayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Habit> objectList;
    private OnItemOnlickListener onItemOnlickListener;
    public DisplayAdapter(List<Habit> objects) {
        this.objectList = objects;
    }

    public void setOnItemOnlickListener(OnItemOnlickListener onItemOnlickListener){
        this.onItemOnlickListener = onItemOnlickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void setObjectList(List<Habit> objectList){
        this.objectList = objectList;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return objectList.size();
    }
    public interface OnItemOnlickListener {
        void onclick(View view);
    }
}
