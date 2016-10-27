package com.zkteco.bigboss.ui.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.util.FragmentCallBack;
import com.zkteco.bigboss.adpater.MesgListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LeaveListFragment extends Fragment {


    private FragmentCallBack callBack;

    private boolean a;

    public LeaveListFragment(boolean b) {
        // Required empty public constructor
        a = b;
    }

    private ListView listView;

    @Override
    public void onResume() {
        super.onResume();
        callBack.SetVisable(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leave_list, container, false);
        listView = (ListView) view.findViewById(R.id.approval_list);
        MesgListAdapter mesgListAdapter = new MesgListAdapter(getActivity());
        listView.setAdapter(mesgListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callBack.GoTo(new LeaveMesegFragment(a));
            }
        });
        return view;
    }

}
