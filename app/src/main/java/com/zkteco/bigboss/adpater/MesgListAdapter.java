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
import com.zkteco.bigboss.util.DateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

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

    public List<QueryAproResponse.PayloadBean.ResultsBean> getList() {
        return resultsBean;
    }

    public int getCount() {
        return resultsBean.size();

    }

    @Override
    public Object getItem(int position) {
        return resultsBean.get(position);
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
                case 5:
                    viewHolder.imag.setBackgroundResource(R.drawable.icon_signthecard_yellow);
                    break;
                case 7:
                    viewHolder.imag.setBackgroundResource(R.drawable.icon_approval_blue_dir);
                    break;
                default:
                    viewHolder.imag.setBackgroundResource(R.drawable.icon_approval_blue_dir);
            }
            if (resultsBean.get(position).getSubType() != null) {
                viewHolder.mesg.setText(resultsBean.get(position).getTitle() + ":" + resultsBean.get(position).getSubType());
            } else {
                viewHolder.mesg.setText(resultsBean.get(position).getTitle());
            }
            switch (resultsBean.get(position).getApproveStatus()) {
                case 0:
                    viewHolder.statu.setText("等待审批");
                    break;
                case 1:
                    viewHolder.statu.setText("审批 通过");
                    break;
                case 2:
                    viewHolder.statu.setText("审批 驳回");
                    break;
            }
            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM");
            String sd = sdf.format(new Date(resultsBean.get(position).getCommitDate()));*/
            viewHolder.time.setText(DateUtils.parseDataYMDHM(resultsBean.get(position).getCommitDate()) + "  >");
        }
        return convertView;
    }

    private static Unbinder unbinder;

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
