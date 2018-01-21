package com.rindia.habit.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.rindia.habit.adapter.HabitAdapter;
import com.rindia.habit.bean.Habit;
import com.rindia.habitKeepTime.R;
import com.shizhefei.fragment.LazyFragment;

import java.util.ArrayList;
import java.util.List;


public class HabitFragment extends LazyFragment {

    private Toolbar mCurrentToolbar;
    private RecyclerView mRecyHabit;
    private HabitAdapter mHabitAdapter;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_habit);
         mRecyHabit = (RecyclerView) this.findViewById(R.id.recy_habit);
         mCurrentToolbar = (Toolbar) findViewById(R.id.toolbar);
       
    }
    private void initData(List<Habit> habits){
        mHabitAdapter = new HabitAdapter(new ArrayList<Habit>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyHabit.setLayoutManager(linearLayoutManager);
        mRecyHabit.setAdapter(mHabitAdapter);
    }

  
}
