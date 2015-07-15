package com.example.tabishhassan.swifty;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.tabishhassan.swifty.data.Tutorial;
import java.util.ArrayList;
import java.util.List;


public class TutorialActivity extends AppCompatActivity {

    ListView listViewTutorial;
    List<Tutorial>  tutorialArray = new ArrayList<Tutorial>();
    LayoutInflater mLayoutInflater;
    int screenWidth,screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenHeight = displaymetrics.heightPixels;
        screenWidth = displaymetrics.widthPixels;
        mLayoutInflater =  getLayoutInflater();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        listViewTutorial = (ListView)findViewById(R.id.listView);
        for(int i = 0 ; i < 10 ; i++)
        {
            tutorialArray.add(new Tutorial("Variable",12,6,R.drawable.ic_launcher));
        }
        ListViewAdapter mAdapter = new ListViewAdapter();
        listViewTutorial.setAdapter(mAdapter);
        listViewTutorial.setDividerHeight(0);
        listViewTutorial.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(TutorialActivity.this,LessonsActivity.class);
                mIntent.putExtra("name",tutorialArray.get(position).getName());
                mIntent.putExtra("totallesseon",tutorialArray.get(position).getTotalNumberOfLec());
                mIntent.putExtra("learned",tutorialArray.get(position).getLearnedLesson());
                mIntent.putExtra("image",tutorialArray.get(position).getImageResource());
                startActivity(mIntent);
            }
        });
    }

    public class ListViewAdapter extends BaseAdapter{

        @Override
        public Object getItem(int position) {
            return tutorialArray.get(position);
        }

        @Override
        public int getCount() {
            return tutorialArray.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHandle mViewHandle =  null;
            if(convertView==null)
            {
                mViewHandle =  new ViewHandle();
                convertView = mLayoutInflater.inflate(R.layout.listitemstutoriallist,null);
                mViewHandle.textViewName = (TextView)convertView.findViewById(R.id.textNameTutorial);
                mViewHandle.textViewTotalLec = (TextView)convertView.findViewById(R.id.texttotalLec);
                mViewHandle.imageBack = (ImageView)convertView.findViewById(R.id.imageView2);
                mViewHandle.layoutItems = (LinearLayout)convertView.findViewById(R.id.layoutitems);
                convertView.setTag(mViewHandle);
            }
            else
            {
                mViewHandle = (ViewHandle)convertView.getTag();
            }
            mViewHandle.textViewName.setText(tutorialArray.get(position).getName());
            mViewHandle.textViewTotalLec.setText(position+"/"+tutorialArray.get(position).getTotalNumberOfLec());
            mViewHandle.imageBack.setBackgroundResource(tutorialArray.get(position).getImageResource());
            mViewHandle.layoutItems.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,31*screenHeight/100));
            return  convertView;
        }

    }
    public static class ViewHandle{
        TextView textViewName,textViewTotalLec;
        ImageView imageBack;
        LinearLayout layoutItems;
    }
}

