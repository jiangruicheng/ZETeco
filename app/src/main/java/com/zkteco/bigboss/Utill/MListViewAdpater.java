package com.zkteco.bigboss.Utill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zkteco.bigboss.view.SelectView;
import com.zkteco.zkteco.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang_ruicheng on 16/10/20.
 */
public class MListViewAdpater extends BaseAdapter {
    private ArrayList<String> ItemText;
    private Context context;
    private int SelectItem;

    public void setItemText(ArrayList itemText) {
        ItemText = itemText;
    }

    public MListViewAdpater(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return ItemText.size();
    }

    @Override
    public Object getItem(int position) {
        return ItemText.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private TextView textView;
    private List<SelectView> views = new ArrayList();

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.poplistview, null);
        textView = (TextView) convertView.findViewById(R.id.type_text);
        final SelectView selectView = (SelectView) convertView.findViewById(R.id.select);
        selectView.setOnClickListen(new SelectView.OnClickListen() {
            @Override
            public void onClick(boolean Select) {
                if (Select) {
                    SelectItem = position;
                    for (SelectView selectView1 : views) {
                        if (selectView1 != selectView && selectView1.isSelect()) {
                            selectView1.setSelect(false);
                        }
                    }
                }
            }
        });
        views.add(selectView);
        if (ItemText != null && !ItemText.isEmpty()) {
            textView.setText(ItemText.get(position));
        }
        return convertView;
    }
}
