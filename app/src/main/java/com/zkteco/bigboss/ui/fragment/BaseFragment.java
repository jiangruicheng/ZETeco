package com.zkteco.bigboss.ui.fragment;


import android.support.v4.app.Fragment;

import com.zkteco.bigboss.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }

    protected void replaceFragment(Fragment fragment) {
        //activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment).addToBackStack("").commit();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment).addToBackStack("").commit();
    }

    protected void popbackFragment() {
        getActivity().getSupportFragmentManager().popBackStack();
    }


}
