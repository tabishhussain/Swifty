package com.example.tabishhassan.swifty;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tabishhassan.swifty.customview.CircleNumView;
import com.tabishhassan.swifty.data.Lesson;
import com.tabishhassan.swifty.fragments.ListViewFragment;

import java.util.ArrayList;
import java.util.List;


public class LessonsActivity extends ActionBarActivity {


    List<Lesson> lessonArray = new ArrayList<Lesson>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenHeight = displaymetrics.heightPixels;
        int screenWidth = displaymetrics.widthPixels;
        LayoutInflater mLayoutInflater =  getLayoutInflater();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        View headerView = mLayoutInflater.inflate(R.layout.listitemstutoriallist,null);
        TextView headerName = (TextView)headerView.findViewById(R.id.textNameTutorial);
        TextView headerCount = (TextView)headerView.findViewById(R.id.texttotalLec);
        ImageView hearderImage = (ImageView)headerView.findViewById(R.id.imageView2);
        Bundle extras = getIntent().getExtras();
        headerName.setText(extras.getString("name"));
        headerCount.setText(extras.getInt("learned") + "/" + extras.getInt("totallesseon"));
        hearderImage.setBackgroundResource(extras.getInt("image"));
        LinearLayout layout = (LinearLayout)findViewById(R.id.layoutHeader);
        layout.addView(headerView);

        ListViewFragment fr = new ListViewFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction mfrFragmentTransaction = manager.beginTransaction();
        mfrFragmentTransaction.replace(R.id.listfragment,fr);
        mfrFragmentTransaction.commit();

    }
}
