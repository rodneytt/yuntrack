package com.osight.rodneytt.yuntrack;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.osight.rodneytt.yuntrack.com.osight.rodneytt.yuntrak.fragment.FragmentHome;
import com.osight.rodneytt.yuntrack.com.osight.rodneytt.yuntrak.fragment.FragmentMovie;
import com.osight.rodneytt.yuntrack.com.osight.rodneytt.yuntrak.fragment.FragmentNews;
import com.osight.rodneytt.yuntrack.com.osight.rodneytt.yuntrak.fragment.FragmentStock;


public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabhost ;
    private LayoutInflater layoutInflater;
    private Class fragmentClassArray [] = {FragmentHome.class, FragmentNews.class, FragmentMovie.class, FragmentStock.class};
    private int tabBtnImageArray[]  ={R.drawable.tab_home_btn,R.drawable.tab_news_btn,R.drawable.tab_movie_btn,R.drawable.tab_stock_btn};
    private String tabBtnTextArray[] = {"首页","新闻","电影","股票"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }
    private void initView(){
        layoutInflater = LayoutInflater.from(this);
        mTabhost = (FragmentTabHost)findViewById(android.R.id.tabhost);

        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        int count = fragmentClassArray.length;
        for(int i=0;i<count;i++){
            TabHost.TabSpec spec = mTabhost.newTabSpec(tabBtnTextArray[i]).setIndicator(getTabItemView(i));
            mTabhost.addTab(spec,fragmentClassArray[i],null);
           // mTabhost.getTabWidget().getChildTabViewAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
    }
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_view,null);
        TextView tv = (TextView)view.findViewById(R.id.textview);
        tv.setText(tabBtnTextArray[index]);
        return view;
    }

}
