package com.zkteco.zkteco;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zkteco.zkteco.view.WeekView;

public class CheckOnWorkFragment extends Fragment {
    private ImageView apply;
    private ImageView approval;

    public CheckOnWorkFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_on_work, container, false);
        WeekView weekView = (WeekView) view.findViewById(R.id.weekview);
        weekView.setLineColor(Color.BLACK);
        apply = (ImageView) view.findViewById(R.id.imag_apply);
        approval = (ImageView) view.findViewById(R.id.imag_approval);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                startActivity(new Intent(getActivity(), ApplyActivity.class));
*/
            }
        });
        approval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
