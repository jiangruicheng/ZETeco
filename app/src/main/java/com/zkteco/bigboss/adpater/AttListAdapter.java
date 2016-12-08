package com.zkteco.bigboss.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.QueryAttResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jiang_ruicheng on 16/11/22.
 */
public class AttListAdapter extends BaseAdapter {
    private List<QueryAttResponse.PayloadBean.ResultsBean.PunchEventListBean> list;

    public void setList(List<QueryAttResponse.PayloadBean.ResultsBean.PunchEventListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list != null)
            return list.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.att_item, null);
        ViewHolder viewHolder = new ViewHolder(convertView);
        if (list != null && !list.isEmpty()) {
            switch (list.get(position).getSubType()) {
                case 0:
                case 1:
                    viewHolder.statu0.setText("正\n常");
                    viewHolder.name0.setText(list.get(position).getSubAttTypeName());
                    viewHolder.value0.setText("打卡时间 :" + list.get(position).getValue());
                    break;
                case 5:
                    viewHolder.statu0.setText("正\n常");
                    viewHolder.name0.setText(list.get(position).getSubAttTypeName());
                    viewHolder.value0.setText(list.get(position).getSubAttTypeName() + ":" + list.get(position).getValue() + "分钟");
                    break;
                default:
                    StringBuffer buffer = new StringBuffer("");
                    for (int i = 0; i < list.get(position).getSubAttTypeName().length(); i++) {
                        if (i != list.get(position).getSubAttTypeName().length() - 1) {
                            buffer = buffer.append(list.get(position).getSubAttTypeName().charAt(i) + "\n");
                        } else {
                            buffer = buffer.append(list.get(position).getSubAttTypeName().charAt(i));
                        }
                    }
                    viewHolder.statu0.setText(buffer.toString());
                    viewHolder.statu0.setBackgroundResource(R.color.colorButtonLogin);
                    viewHolder.name0.setText(list.get(position).getSubAttTypeName());
                    viewHolder.value0.setText(list.get(position).getSubAttTypeName() + ":" + list.get(position).getValue() + "分钟");
                    break;
            }
        }
        return convertView;
    }

    private static Unbinder unbinder;

    static class ViewHolder {
        @BindView(R.id.statu0)
        TextView statu0;
        @BindView(R.id.name0)
        TextView name0;
        @BindView(R.id.value0)
        TextView value0;
        @BindView(R.id.type0)
        LinearLayout type0;

        ViewHolder(View view) {
            unbinder = ButterKnife.bind(this, view);
        }
    }

    public static void setUnbinder() {
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
