package com.zkteco.bigboss.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.zkteco.bigboss.R;
import com.zkteco.bigboss.adpater.PopWindowManager;
import com.zkteco.bigboss.bean.json.bean.CounAddress;
import com.zkteco.bigboss.mvp.presenter.SetupCompanyPresenter;
import com.zkteco.bigboss.mvp.view.SetupCompanyView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetupCompanyFragment extends Fragment implements SetupCompanyView {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.editcmpname)
    EditText editcmpname;
    @BindView(R.id.getindus)
    ImageView getindus;
    @BindView(R.id.Edit_location)
    TextView EditLocation;
    @BindView(R.id.getlocation)
    ImageView getlocation;
    @BindView(R.id.editaddress)
    EditText editaddress;
    @BindView(R.id.setup)
    Button setup;

    @OnClick(R.id.setup)
    void setSetup() {
        presenter.setup(id);
    }

    @OnClick(R.id.getindus)
    void setGetindus() {
        presenter.checkoutindu();
    }

    private SetupCompanyPresenter presenter;

    public SetupCompanyFragment() {
        // Required empty public constructor
    }

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setup_company, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void getaddressjson() {
        Gson gson = new Gson();
        InputStream inputStream = getActivity().getResources().openRawResource(R.raw.address);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Reader reader = new BufferedReader(inputStreamReader);
        JsonReader jsonreader = new JsonReader(reader);
        List<CounAddress> addresses = gson.fromJson(jsonreader, new TypeToken<List<CounAddress>>() {
        }.getType());
        Log.i("json", "getaddressjson: " + addresses.get(1).getSubArea().get(0).getSubArea().get(0).getName());
    }

    int id;

    @Override
    public void showindus(final List<String> cmpIndusResponse) {
        PopWindowManager.popListWindow(getActivity(), setup, (ArrayList) cmpIndusResponse, new PopWindowManager.Popviewcallback() {
            @Override
            public void callback(int p) {
                id = p;
            }
        });
    }

    @Override
    public void setPresenter(SetupCompanyPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
