package com.zkteco.bigboss.ui.fragment;


import android.support.v4.app.Fragment;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.mvp.BasePresenter;
import com.zkteco.bigboss.mvp.BaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }

    protected void replaceFragment(Fragment fragment, BasePresenter presenter) {
        //activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment).addToBackStack("").commit();
        if (presenter != null && fragment instanceof BaseView) {
            ((BaseView) fragment).setPresenter(presenter);
            presenter.setview((BaseView) fragment);
        }
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment).addToBackStack("").commit();
    }

    protected void popbackFragment() {
        getActivity().getSupportFragmentManager().popBackStack();
    }


}
