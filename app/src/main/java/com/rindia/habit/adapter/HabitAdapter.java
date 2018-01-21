package com.rindia.habit.adapter;

import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rindia.habit.bean.Habit;
import com.rindia.habitKeepTime.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 汪磊 on 2018/1/3.
 */

public class HabitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Habit> habitList;
    private int viewHolderType;
    public static final int VIEWHOLDER_TYPE_DISPLAY = 1;
    public static final int VIEWHOLDER_TYPE_EDITOR = 2;
    private OnItemClickLinsetner onItemClickLinsetner;

    public HabitAdapter(List<Habit> habitList) {
        this.habitList = habitList;
        viewHolderType = VIEWHOLDER_TYPE_DISPLAY;
    }

    public void setViewHolderType(@IntRange(from = 1, to = 2) int type) {
        this.viewHolderType = type;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == VIEWHOLDER_TYPE_DISPLAY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habit_fragment_recy_item, null);
            viewHolder = new HabitViewHolder(view);
        } else {
            //TODO 设定编辑状态的viewholder
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habit_fragment_recy_item_edit, null);
            viewHolder = new EditorViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Habit habit = habitList.get(position);
        if (viewHolderType == VIEWHOLDER_TYPE_DISPLAY) {
            HabitViewHolder viewHolder = (HabitViewHolder) holder;

            viewHolder.img_item.setImageResource(Integer.valueOf(habit.getHabitImageId()));
            viewHolder.tv_item_name.setText(habit.getHabitName());
            viewHolder.tv_item_time.setText(habit.getHabitKeepDay());
            viewHolder.tv_item_remind_time.setText(habit.getHabitRemindTime());
            viewHolder.itemView.setTag(position);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLinsetner.onItemClick(v, ((int) v.getTag()));
                }
            });
            viewHolder.img_check_today.setVisibility(View.GONE);
        } else {
            EditorViewHolder viewHolder = (EditorViewHolder) holder;
            viewHolder.tv_habit_edit_name.setText(habit.getHabitName());
            viewHolder.itemView.setTag(position);
        }
    }

    public void setOnItemClickLinsetner(OnItemClickLinsetner onItemClickLinsetner) {
        this.onItemClickLinsetner = onItemClickLinsetner;
    }

    public interface OnItemClickLinsetner {
        void onItemClick(View v, int position);
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewHolderType;
    }

    class HabitViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView img_item;
        private TextView tv_item_name;
        private TextView tv_item_time;
        private TextView tv_item_remind_time;
        private ImageView img_check_today;

        HabitViewHolder(View view) {
            super(view);
            img_item = (CircleImageView) view.findViewById(R.id.img_item);
            tv_item_name = (TextView) view.findViewById(R.id.tv_item_name);
            tv_item_time = (TextView) view.findViewById(R.id.tv_item_time);
            tv_item_remind_time = (TextView) view.findViewById(R.id.tv_item_remind_time);
            img_check_today = (ImageView) view.findViewById(R.id.img_check_today);
        }
    }
    

    class EditorViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_habit_edit_name;
        public ImageView img_habit_edit_move_position;
        public ImageView img_habit_edit_delete_habit;

        public EditorViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_habit_edit_name = (TextView) rootView.findViewById(R.id.tv_habit_edit_name);
            this.img_habit_edit_move_position = (ImageView) rootView.findViewById(R.id.img_habit_edit_move_position);
            this.img_habit_edit_delete_habit = (ImageView) rootView.findViewById(R.id.img_habit_edit_delete_habit);
        }

    }
}
