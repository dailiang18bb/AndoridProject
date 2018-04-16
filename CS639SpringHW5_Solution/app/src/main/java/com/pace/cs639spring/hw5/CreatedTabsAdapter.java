package com.pace.cs639spring.hw5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CreatedTabsAdapter extends BaseAdapter {

    Context mContext;
    private List<TabInformation> mTabsInformation;


    public CreatedTabsAdapter(Context context) {
        mContext = context;
        mTabsInformation = new ArrayList<>();
    }


    public void addNewTab(TabInformation tabInfo) {
        mTabsInformation.add(tabInfo);
    }

    public void removeAllTabInformation() {
        mTabsInformation.clear();
    }

    public List<TabInformation> getTabInformation() {
        return mTabsInformation;
    }


    @Override
    public int getCount() {
        return mTabsInformation.size();
    }

    @Override
    public Object getItem(int position) {
        return mTabsInformation.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_item, null);
        }
        TabInformation personalInfo = (TabInformation) getItem(position);
        ((TextView) convertView.findViewById(R.id.name)).setText(personalInfo.mName);
        ((TextView) convertView.findViewById(R.id.bio)).setText(personalInfo.mBiography);
        return convertView;
    }
}
