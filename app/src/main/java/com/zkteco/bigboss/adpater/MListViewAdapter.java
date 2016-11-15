package com.zkteco.bigboss.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.view.SelectView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jiang_ruicheng on 16/10/20.
 */
public class MListViewAdapter extends BaseAdapter {
    private ArrayList<String> ItemText;
    private Context context;
    private int SelectItem;

    public void setItemText(ArrayList itemText) {
        ItemText = itemText;
    }

    public MListViewAdapter(Context context) {
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

    private List<SelectView> views = new ArrayList();

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.poplistview, null);
        final ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.select.setOnClickListen(new SelectView.OnClickListen() {
            @Override
            public void onClick(boolean Select) {
                if (Select) {
                    SelectItem = position;
                    for (SelectView selectView1 : views) {
                        if (selectView1 != viewHolder.select && selectView1.isSelect()) {
                            selectView1.setSelect(false);
                        }
                    }
                }
            }
        });
        views.add(viewHolder.select);
        if (ItemText != null && !ItemText.isEmpty()) {
            viewHolder.typeText.setText(ItemText.get(position));
        }
        return convertView;
    }

    private static Unbinder unbinder;

    static class ViewHolder {
        @BindView(R.id.type_text)
        TextView typeText;
        @BindView(R.id.select)
        SelectView select;

        ViewHolder(View view) {
            unbinder = ButterKnife.bind(this, view);
        }
    }

    public static void setUnbinder() {
        unbinder.unbind();
        unbinder = null;
    }
}
