package com.zkteco.bigboss.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.QueryReviewersResponse;

import java.util.ArrayList;

/**
 * Created by jiang_ruicheng on 16/11/16.
 */
public class ReviewersAdpater extends RecyclerView.Adapter<ReviewersAdpater.myViewHolder> implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(int posion);
    }

    public ArrayList<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> getResultsBeen() {
        return resultsBeen;
    }

    private ArrayList<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> resultsBeen;

    public void setResultsBeen(ArrayList<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> been) {
        resultsBeen = been;
        notifyDataSetChanged();
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.approver_list_item, parent, false);
        return new myViewHolder(view);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        if (resultsBeen != null) {
            holder.name.setText(String.valueOf(resultsBeen.get(position).getName()));
            if (onItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(position);
                    }
                });
            }
        }
    }

    @Override
    public long getHeaderId(int position) {
        if (resultsBeen.get(position).getFirstLetter() != null) {
            //Log.i("TAG", "getHeaderId: " + resultsBeen.get(position).getFirstLetter().toUpperCase().charAt(0));
            return resultsBeen.get(position).getFirstLetter().toUpperCase().charAt(0);
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_header, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };

    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (resultsBeen != null) {
            TextView textView = (TextView) holder.itemView;
            textView.setText(resultsBeen.get(position).getFirstLetter());
        }
    }

    @Override
    public int getItemCount() {
        if (resultsBeen != null) {
            return resultsBeen.size();
        }
        return 0;
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        ImageView approverimag;
        TextView name;
        TextView job;

        public myViewHolder(View itemView) {
            super(itemView);
            approverimag = (ImageView) itemView.findViewById(R.id.approverimag);
            name = (TextView) itemView.findViewById(R.id.name);
            job = (TextView) itemView.findViewById(R.id.job);
        }
    }
}
