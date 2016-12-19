package com.zkteco.bigboss.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
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
import com.zkteco.bigboss.bean.json.SetupCmpRequest;
import com.zkteco.bigboss.bean.json.bean.CounAddress;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.presenter.SetupCompanyPresenter;
import com.zkteco.bigboss.mvp.view.SetupCompanyView;
import com.zkteco.bigboss.ui.activity.LoginActivity;
import com.zkteco.bigboss.util.MD5;
import com.zkteco.bigboss.view.MyRelativeLayout;
import com.zkteco.bigboss.view.com.bigkoo.pickerview.OptionsPickerView;
import com.zkteco.bigboss.view.com.bigkoo.pickerview.listener.OnDismissListener;
import com.zkteco.bigboss.view.com.bigkoo.pickerview.model.IPickerViewData;

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
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetupCompanyFragment extends BaseFragment implements SetupCompanyView {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.Edit_indus)
    TextView EditIndus;
    @BindView(R.id.indus_layout)
    MyRelativeLayout indusLayout;

    @OnClick(R.id.indus_layout)
    void setGetindus() {
        presenter.checkoutindu();
    }

    @BindView(R.id.address_layout)
    MyRelativeLayout addressLayout;

    @OnClick(R.id.address_layout)
    void setGetlocation() {
        showprog("");
        showaddress();
    }

    @OnClick(R.id.back)
    void onback() {
        popbackFragment();
    }

    @BindView(R.id.editcmpname)
    EditText editcmpname;
    @BindView(R.id.getindus)
    ImageView getindus;

    /*@OnClick(R.id.getindus)
    void setGetindus() {
        presenter.checkoutindu();
    }*/

    @BindView(R.id.Edit_location)
    TextView EditLocation;
    @BindView(R.id.getlocation)
    ImageView getlocation;

/*    @OnClick(R.id.getlocation)
    void setGetlocation() {
        showaddress();
    }*/

    @BindView(R.id.editaddress)
    EditText editaddress;
    @BindView(R.id.setup)
    Button setup;

    @OnClick(R.id.setup)
    void setSetup() {
        paramsBean.setCmpName(editcmpname.getText().toString());
        paramsBean.setCmpAddress(editaddress.getText().toString());
        paramsBean.setAgree(true);
        paramsBean.setIscompany(true);
        paramsBean.setUsername(UserMesg.getInstance().getAccount());
        paramsBean.setFirstName(UserMesg.getInstance().getUsername());
        paramsBean.setPassword(MD5.GetMD5Code(UserMesg.getInstance().getPassword()));
        presenter.setup(paramsBean, getActivity());

    }

    private SetupCmpRequest.PayloadBean.ParamsBean paramsBean;


    private SetupCompanyPresenter presenter;

    public SetupCompanyFragment() {
        // Required empty public constructor
        paramsBean = new SetupCmpRequest.PayloadBean.ParamsBean();
    }

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setup_company, container, false);
        unbinder = ButterKnife.bind(this, view);
        EditLocation.setMovementMethod(ScrollingMovementMethod.getInstance());
        EditIndus.setMovementMethod(ScrollingMovementMethod.getInstance());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private List<CounAddress> addressList;

    private List<CounAddress> getaddressjson() {
        Gson gson = new Gson();
        InputStream inputStream = getActivity().getResources().openRawResource(R.raw.address);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        Reader reader = new BufferedReader(inputStreamReader);
        JsonReader jsonreader = new JsonReader(reader);
        List<CounAddress> addresses = gson.fromJson(jsonreader, new TypeToken<List<CounAddress>>() {
        }.getType());
        Log.i("json", "getaddressjson: " + addresses.get(1).getSubArea().get(0).getSubArea().get(0).getName());
        addressList = addresses;
        return addresses;
    }

    private ArrayList<IPickerViewData> item0 = new ArrayList<>();
    private ArrayList<ArrayList<IPickerViewData>> item1 = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<IPickerViewData>>> item2 = new ArrayList<>();
    private OptionsPickerView optionsPickerView;

    private void showaddress() {
        Observable.just(getaddressjson()).map(new Func1<List<CounAddress>, OptionsPickerView>() {
            @Override
            public OptionsPickerView call(final List<CounAddress> counAddresses) {

                if (item0.size() == 0) {
                    for (int i = 0; i < counAddresses.size(); i++) {
                        item0.add(new ItemString(counAddresses.get(i).getName()));
                        ArrayList<IPickerViewData> item1_i = new ArrayList<IPickerViewData>();
                        ArrayList<ArrayList<IPickerViewData>> item2_i = new ArrayList<ArrayList<IPickerViewData>>();
                        for (int j = 0; j < counAddresses.get(i).getSubArea().size(); j++) {
                            item1_i.add(new ItemString(counAddresses.get(i).getSubArea().get(j).getName()));
                            ArrayList<IPickerViewData> item2_i_i = new ArrayList<IPickerViewData>();

                            for (int k = 0; k < counAddresses.get(i).getSubArea().get(j).getSubArea().size(); k++) {
                                item2_i_i.add(new ItemString(counAddresses.get(i).getSubArea().get(j).getSubArea().get(k).getName()));
                            }
                            item2_i.add(item2_i_i);
                        }
                        item1.add(item1_i);
                        item2.add(item2_i);
                    }
                }

                return null;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new Observer<OptionsPickerView>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(OptionsPickerView o) {
                optionsPickerView = new OptionsPickerView(getActivity());
                optionsPickerView.setPicker(item0, item1, item2, true);
                optionsPickerView.setCyclic(false, false, false);
                displayprog();
                optionsPickerView.show();
                optionsPickerView.setOnDismissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss(Object o) {
                        ((LoginActivity) getActivity()).dissetback();
                        optionsPickerView = null;
                    }
                });
                ((LoginActivity) getActivity()).setBack(new LoginActivity.Setbackcallback() {
                    @Override
                    public void backcallback() {
                        optionsPickerView.dismiss();
                    }
                });
                optionsPickerView.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        /*sheng = options1;
                        shi = option2;
                        xian = options3;*/
                        paramsBean.setProvince(Integer.toString(addressList.get(options1).getAreaId()));
                        paramsBean.setCity(Integer.toString(addressList.get(options1).getSubArea().get(option2).getAreaId()));
                        paramsBean.setDistrict(Integer.toString(addressList.get(options1).getSubArea().get(option2).getSubArea().get(options3).getAreaId()));
                        EditLocation.setText(addressList.get(options1).getName() + addressList.get(options1).getSubArea().get(option2).getName() + addressList.get(options1).getSubArea().get(option2).getSubArea().get(options3).getName());
                    }
                });
               /* Class optclass = optionsPickerView.getClass();
                //optionsPickerView.setSelectOptions(3,3,3);
                try {
                    Object wheelopt = optclass.getDeclaredField("wheelOptions").get(optionsPickerView);
                    Class wheeloptclass = wheelopt.getClass();
                    Field wv_option1 = wheeloptclass.getDeclaredField("wv_option1");
                    wv_option1.setAccessible(true);
                    Object wheelview = wv_option1.get(wheelopt);
                    Class wheelviewclass = wheelview.getClass();
                    Field textsiz1 = wheelviewclass.getDeclaredField("textSize");
                    textsiz1.setAccessible(true);
                    textsiz1.set(wheelview, 145);
                    Log.i("TAG", "onNext: " + ((Integer) (textsiz1.get(wheelview))).intValue());
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }*/

                Log.i("TAG", "onNext: ");
            }
        });
    }

    @Override
    public void showindus(final List<String> cmpIndusResponse) {
        PopWindowManager.popListWindow(getActivity(), setup, (ArrayList) cmpIndusResponse, new PopWindowManager.Popviewcallback() {
            @Override
            public void callback(int p) {
                paramsBean.setIndustryId(presenter.getIndID(p));
                EditIndus.setText(presenter.getIndName(p));
            }
        }, "选择所属行业");
    }

    @Override
    public void showprogs(String mesg) {
        showprog("");
    }

    @Override
    public void displayprogs() {
        displayprog();
    }

    @Override
    public void setPresenter(SetupCompanyPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    class ItemString implements IPickerViewData {
        public ItemString(String s) {
            name = s;
        }

        private String name;

        @Override
        public String getPickerViewText() {
            return name;
        }
    }
}
