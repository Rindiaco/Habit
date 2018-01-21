package com.rindia.habit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rindia.habit.fragment.DisplayFragment;
import com.rindia.habitKeepTime.R;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Indicator mIndicator;
    private IndicatorViewPager mIndicatorViewPager;
    private List<Fragment> mFragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setFragmentList();
    }
    private void initView(){
        mViewPager = (ViewPager) findViewById(R.id.vp_main);
        mIndicator = (Indicator) findViewById(R.id.indicator_main);
        mIndicatorViewPager = new IndicatorViewPager(mIndicator,mViewPager);
    }
    private void setFragmentList(){
        mFragmentList = new ArrayList<>(4);
        mFragmentList.add(new DisplayFragment());
        mFragmentList.add(new DisplayFragment());
        mFragmentList.add(new DisplayFragment());
        mFragmentList.add(new DisplayFragment());
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        
        mIndicatorViewPager.setAdapter(adapter);
        
    }
    private class MainViewPagerAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter{

       public MainViewPagerAdapter(FragmentManager fm) {
           super(fm);
       }

        @Override
        public Fragment getFragmentForPage(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null){
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_item,null);
            }
            TextView textView =(TextView) convertView.findViewById(R.id.tv_tab_name);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.img_tab_icon);
            textView.setText("test"+position);
            return convertView;
        }

        @Override
       public int getCount() {
           return mFragmentList.size();
       }

    }
}
