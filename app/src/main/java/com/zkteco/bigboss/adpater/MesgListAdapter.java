package com.zkteco.bigboss.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.QueryAproResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jiang_ruicheng on 16/10/21.
 */
public class MesgListAdapter extends BaseAdapter {
    private Context context;

    public MesgListAdapter(Context context) {
        this.context = context;
    }

    private List<QueryAproResponse.PayloadBean.ResultsBean> resultsBean = new ArrayList<>();

    public void setList(List<QueryAproResponse.PayloadBean.ResultsBean> list) {
        resultsBean = list;
    }

    public int getCount() {
        //return resultsBean.size();
        return 1;

    }

    @Override
    public Object getItem(int position) {
        //return resultsBean.get(position);
        return 1;

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.mesglist, null);
        ViewHolder viewHolder;
        viewHolder = new ViewHolder(convertView);
        if (resultsBean != null && !resultsBean.isEmpty()) {
            switch (resultsBean.get(position).getType()) {
                default:
                    viewHolder.imag.setBackgroundResource(R.drawable.icon_apply_yellow);
            }
            viewHolder.mesg.setText(resultsBean.get(position).getTitle());
            switch (resultsBean.get(position).getApproveStatus()) {
                case 0:
                    viewHolder.statu.setText("");
                    break;
                case 1:
                    viewHolder.statu.setText("审批 通过");
                    break;
                case 2:
                    viewHolder.statu.setText("审批 驳回");
                    break;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
            String sd = sdf.format(new Date(resultsBean.get(position).getCommitDate()));
            viewHolder.time.setText(sd);
        } else {
            viewHolder.statu.setText("审批 通过");
            viewHolder.time.setText("11小时前  >");
            viewHolder.imag.setBackgroundResource(R.drawable.icon_apply_yellow);
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imag)
        ImageView imag;
        @BindView(R.id.mesg)
        TextView mesg;
        @BindView(R.id.statu)
        TextView statu;
        @BindView(R.id.time)
        TextView time;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
