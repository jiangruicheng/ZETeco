package com.zkteco.bigboss.ui.fragment;


import android.app.ProgressDialog;
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

    private ProgressDialog progressDialog;

    protected void showprog(String mesg) {
        progressDialog = new ProgressDialog(getActivity(), android.R.style.Theme_Material_Light_Dialog);
        if (mesg != null) {
            progressDialog.setMessage("loading");
            progressDialog.show();
        }
        progressDialog.show();
    }

    protected void displayprog() {
        progressDialog.dismiss();
    }
}
