package com.zkteco.bigboss.mvp.presenter.Impl;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.zkteco.bigboss.bean.json.CheckoutCmpindusRequest;
import com.zkteco.bigboss.bean.json.CmpIndusResponse;
import com.zkteco.bigboss.bean.json.SetupCmpRequest;
import com.zkteco.bigboss.bean.json.SetupCmpResponse;
import com.zkteco.bigboss.bean.json.bean.UserMesg;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.mode.ZKTecoRequest;
import com.zkteco.bigboss.mvp.presenter.LoginPresenter;
import com.zkteco.bigboss.mvp.presenter.SetupCompanyPresenter;
import com.zkteco.bigboss.mvp.view.LoginView;
import com.zkteco.bigboss.mvp.view.SetupCompanyView;

import java.util.ArrayList;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by jiang_ruicheng on 16/11/3.
 */
public class SetupCompanyPresenterImpl implements SetupCompanyPresenter {
    private SetupCompanyView view;
    private CheckoutCmpindusRequest checkoutCmpindusRequest;
    private CmpIndusResponse cmpIndus;

    @Override
    public void checkoutindu() {
        checkoutCmpindusRequest = new CheckoutCmpindusRequest();

        Subscription subscription = ZKTecoRequest.getListApi().
                checkoutindu(checkoutCmpindusRequest).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                map(new Func1<CmpIndusResponse, ArrayList<String>>() {
                    @Override
                    public ArrayList<String> call(CmpIndusResponse cmpIndusResponse) {
                        ArrayList<String> item = new ArrayList<String>();
                        cmpIndus = cmpIndusResponse;
                        for (int i = 0; i < cmpIndusResponse.getPayload().getResults().size(); i++) {
                            item.add(cmpIndusResponse.getPayload().getResults().get(i).getName());
                        }
                        return item;
                    }
                }).subscribe(new Observer<ArrayList<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.postmesg(e.getMessage());
                Log.i("TAG", "onError: " + e.getMessage());
            }

            @Override
            public void onNext(ArrayList<String> strings) {
                view.showindus(strings);
            }
        });
    }

    SetupCmpRequest request;

    @Override
    public void setup(SetupCmpRequest.PayloadBean.ParamsBean paramsBean, final Context context) {
        request = new SetupCmpRequest();
        request.getPayload().setParams(paramsBean);
        Subscription subscription = ZKTecoRequest.getAccountAPI().
                setupcmp(request).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).
                subscribe(new Observer<SetupCmpResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.postmesg(e.getMessage());
                    }

                    @Override
                    public void onNext(SetupCmpResponse setupCmpResponse) {
                        if (setupCmpResponse.getCode().equals("00000000")) {
                            LoginPresenter presenter = new LoginPresenterImpl();
                            presenter.setview(new LoginView() {
                                ProgressDialog progressDialog;

                                @Override
                                public void showprogs() {
                                    progressDialog = new ProgressDialog(context);
                                    progressDialog.setMessage("正在登陆");
                                    progressDialog.show();
                                }

                                @Override
                                public void displayprogs() {
                                    progressDialog.dismiss();
                                }

                                @Override
                                public void setPresenter(LoginPresenter presenter) {

                                }

                                @Override
                                public void postmesg(String msg) {
                                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                                }
                            });
                            presenter.login(context, UserMesg.getInstance().getAccount(), UserMesg.getInstance().getPassword());

                        } else {
                            view.postmesg(setupCmpResponse.getMessage());
                        }
                    }
                });
        /*LoginPresenter presenter = new LoginPresenterImpl();
        presenter.login(context, "15001372759", "123456");*/
    }

    @Override
    public String getIndID(int id) {
        if (cmpIndus != null)
            return cmpIndus.getPayload().getResults().get(id).getIndustryId() + "";
        return null;
    }

    @Override
    public String getIndName(int id) {
        if (cmpIndus != null)
            return cmpIndus.getPayload().getResults().get(id).getName() + "";
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void setview(BaseView view) {
        this.view = (SetupCompanyView) view;
    }
}
