package com.tabishhassan.swifty.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tabishhassan.swifty.R;
import com.tabishhassan.swifty.customview.CircleNumView;
import com.tabishhassan.swifty.data.Lesson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tabishhassan on 7/15/15.
 */
public class ListViewFragment extends ListFragment {
    List<Lesson> lessonArray = new ArrayList<Lesson>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(int i = 0 ; i < 10 ; i++)
        {
            boolean learned ;
            if(i%2==0)learned = true;
            else learned=false;
            Lesson obj = new Lesson("While-loop",learned);
            lessonArray.add(obj);
        }

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LessonListViewAdapter mLessonListViewAdapter = new LessonListViewAdapter(getActivity(),lessonArray);
        getListView().setAdapter(mLessonListViewAdapter);
        setListShown(true);
        getListView().setDividerHeight(0);
    }

    public class LessonListViewAdapter extends BaseAdapter {
        List<Lesson> lessonList = new ArrayList<Lesson>();
        LayoutInflater mLayoutInflater;
        Activity context;
        public LessonListViewAdapter(Activity c,List<Lesson> listlesson)
        {
            context = c;
            lessonList = listlesson;
            mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public Object getItem(int position) {
            return lessonList.get(position);
        }

        @Override
        public int getCount() {
            return lessonList.size();
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
                convertView = mLayoutInflater.inflate(R.layout.listitemslessonlist,null);
                mViewHandle.textViewName = (TextView)convertView.findViewById(R.id.textlessonname);
                mViewHandle.indexView = (CircleNumView)convertView.findViewById(R.id.customindex);
                convertView.setTag(mViewHandle);
            }
            else
            {
                mViewHandle = (ViewHandle)convertView.getTag();
            }
            mViewHandle.textViewName.setText(lessonList.get(position).getName());
            mViewHandle.indexView.setCircleText("" + (position + 1));
            if(position==0)
            {
                mViewHandle.indexView.setCheckfirstandlast(1);
            }
            else if(position==lessonList.size()-1)
            {
                mViewHandle.indexView.setCheckfirstandlast(2);
            }
            else
            {
                mViewHandle.indexView.setCheckfirstandlast(0);
            }
            if(lessonList.get(position).getis_Learned())
            {
                mViewHandle.indexView.setIs_learned(true);
            }
            else if(!lessonList.get(position).getis_Learned())
            {
                mViewHandle.indexView.setIs_learned(false);
            }
            return  convertView;
        }

    }
    public static class ViewHandle{
        TextView textViewName;
        CircleNumView indexView;
    }
}
