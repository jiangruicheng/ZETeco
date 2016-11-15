package com.zkteco.bigboss.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zkteco.bigboss.R;
import com.zkteco.bigboss.bean.json.SearchCompanyResponse;
import com.zkteco.bigboss.mvp.presenter.ApplyJoinCompanyPresenter;
import com.zkteco.bigboss.mvp.view.ApplyJoinCompanyView;
import com.zkteco.bigboss.util.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ApplyJoinCompanyFragment extends BaseFragment implements ApplyJoinCompanyView {


    @BindView(R.id.back)
    ImageView back;

    @OnClick(R.id.back)
    void onback() {
        popbackFragment();
    }

    @BindView(R.id.search_imag)
    ImageView searchImag;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.search_button)
    Button searchButton;
    @BindView(R.id.applyjoincompany)
    Button applyjoincompany;
    @BindView(R.id.companymesglist)
    LinearLayout companymesglist;
    @BindView(R.id.showid)
    TextView showid;
    @BindView(R.id.showname)
    TextView showname;
    @BindView(R.id.showindustrydesc)
    TextView showindustrydesc;
    @BindView(R.id.showaddress)
    TextView showaddress;

    @OnClick(R.id.search_button)
    void onsearch() {
        if (StringUtil.isNotEmptyIgnoreBlank(searchEdit.getText().toString())) {
            presenter.search(searchEdit.getText().toString());
        } else {
            postmesg("请输入企业ID");
        }
    }

    private SearchCompanyResponse searchCompanyResponse;

    @OnClick(R.id.applyjoincompany)
    void applyjoin() {
        if (searchCompanyResponse != null && searchCompanyResponse.getCode().equals("00000000")) {
            presenter.applyjoin();
        }
    }

    public ApplyJoinCompanyFragment() {
        // Required empty public constructor
    }

    private Unbinder unbinder;
    private ApplyJoinCompanyPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apply_join_company, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void displayList() {

    }

    @Override
    public void showList(SearchCompanyResponse mesg) {
        this.searchCompanyResponse = mesg;
        if (mesg.getCode().equals("00000000")) {
            showid.setText(mesg.getPayload().getResults().getCmpId());
            showaddress.setText(mesg.getPayload().getResults().getCmpAddress());
            showname.setText(mesg.getPayload().getResults().getCmpName());
            showindustrydesc.setText(mesg.getPayload().getResults().getIndustryDesc());
            companymesglist.setVisibility(View.VISIBLE);
            result.setVisibility(View.GONE);
        } else {
            result.setVisibility(View.VISIBLE);
            companymesglist.setVisibility(View.GONE);
        }
    }


    @Override
    public void setPresenter(ApplyJoinCompanyPresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
