package com.zkteco.zkteco.Utill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zkteco.zkteco.R;

/**
 * Created by jiang_ruicheng on 16/10/21.
 */
public class MesgListAdpater extends BaseAdapter {
    private Context context;

    public MesgListAdpater(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return 2;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.mesglist, null);
        return convertView;
    }
}
