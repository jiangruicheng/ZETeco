package com.zkteco.zkteco;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zkteco.zkteco.Utill.MesgListAdpater;


/**
 * A simple {@link Fragment} subclass.
 */
public class LeaveListFragment extends Fragment {


    public LeaveListFragment() {
        // Required empty public constructor
    }

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leave_list, container, false);
        listView = (ListView) view.findViewById(R.id.approval_list);
        MesgListAdpater mesgListAdpater = new MesgListAdpater(getActivity());
        listView.setAdapter(mesgListAdpater);
        return view;
    }

}
