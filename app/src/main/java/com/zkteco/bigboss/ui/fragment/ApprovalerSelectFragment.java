package com.zkteco.bigboss.ui.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bigkoo.quicksidebar.QuickSideBarTipsView;
import com.bigkoo.quicksidebar.QuickSideBarView;
import com.bigkoo.quicksidebar.listener.OnQuickSideBarTouchListener;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.zkteco.bigboss.R;
import com.zkteco.bigboss.adpater.ReviewersAdpater;
import com.zkteco.bigboss.bean.json.QueryReviewersResponse;
import com.zkteco.bigboss.mvp.presenter.QueryReviewersPresenter;
import com.zkteco.bigboss.mvp.view.ReviewersView;
import com.zkteco.bigboss.util.FragmentCallBack;
import com.zkteco.bigboss.util.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
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
@SuppressLint("ValidFragment")
public class ApprovalerSelectFragment extends BasemainFragment implements ReviewersView {
    private ArrayList<String> letters = new ArrayList<>();
    private HashMap<String, Integer> lettermap = new HashMap<>();
    private ReviewersAdpater adpater;
    private List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> resultsBeen;
    private StickyRecyclerHeadersDecoration headersDecoration;
    private int page = 1;

    @Override
    public void showList(final List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> resultsBeen) {
        this.resultsBeen = resultsBeen;
        /*for (int i = 0; i < resultsBeen.size(); i++) {
            resultsBeen.get(i).setFirstLetter(StringHelper.getHeadChar(StringHelper.getPingYin(resultsBeen.get(i).getName())));
            if (!lettermap.containsKey(resultsBeen.get(i).getFirstLetter())) {
                letters.add(resultsBeen.get(i).getFirstLetter());
                lettermap.put(resultsBeen.get(i).getFirstLetter(), i);
            }
        }
        adpater = new ReviewersAdpater();
        adpater.setResultsBeen((ArrayList<QueryReviewersResponse.PayloadBean.ResultsBean>) resultsBeen);
        quickSideBarView.setLetters(letters);
        recyclerView.setAdapter(adpater);
        StickyRecyclerHeadersDecoration headersDecoration = new StickyRecyclerHeadersDecoration(adpater);
        recyclerView.addItemDecoration(headersDecoration);
        quickSideBarView.setOnQuickSideBarTouchListener(new OnQuickSideBarTouchListener() {
            @Override
            public void onLetterChanged(String letter, int position, float y) {
                if (lettermap.containsKey(letter)) {
                    recyclerView.scrollToPosition(lettermap.get(letter));
                }
            }

            @Override
            public void onLetterTouching(boolean touching) {

            }
        });
        adpater.setOnItemClickListener(new ReviewersAdpater.OnItemClickListener() {
            @Override
            public void onItemClick(int posion) {
                setID.setID(resultsBeen.get(posion).getEmpId());
                callBack.Back(ApprovalerSelectFragment.this);
            }
        });*/
        Observable.just(resultsBeen).
                map(new Func1<List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean>, List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean>>() {

                    @Override
                    public List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> call(List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> resultsBeen) {
                        for (int i = 0; i < resultsBeen.size(); i++) {
                            resultsBeen.get(i).setFirstLetter(StringHelper.getHeadChar(StringHelper.getPingYin(resultsBeen.get(i).getName())));
                            resultsBeen.get(i).setPingyinfirst(StringHelper.getPinYinHeadChar(resultsBeen.get(i).getName()));
                            if (!lettermap.containsKey(resultsBeen.get(i).getFirstLetter())) {
                                letters.add(resultsBeen.get(i).getFirstLetter());
                                lettermap.put(resultsBeen.get(i).getFirstLetter(), i);
                            }
                        }

                        return resultsBeen;
                    }
                }).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> resultsBeen) {
                        adpater = new ReviewersAdpater();
                        adpater.setResultsBeen((ArrayList<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean>) resultsBeen);
                        quickSideBarView.setLetters(letters);
                        recyclerView.setAdapter(adpater);
                        if (headersDecoration == null) {
                            headersDecoration = new StickyRecyclerHeadersDecoration(adpater);
                        } else {
                            headersDecoration.invalidateHeaders();
                        }
                        recyclerView.addItemDecoration(headersDecoration);
                        quickSideBarView.setOnQuickSideBarTouchListener(new OnQuickSideBarTouchListener() {
                            @Override
                            public void onLetterChanged(String letter, int position, float y) {
                                if (lettermap.containsKey(letter)) {
                                    recyclerView.scrollToPosition(lettermap.get(letter));
                                }
                            }

                            @Override
                            public void onLetterTouching(boolean touching) {

                            }
                        });
                        adpater.setOnItemClickListener(new ReviewersAdpater.OnItemClickListener() {
                            @Override
                            public void onItemClick(int posion) {
                                setID.setID(resultsBeen.get(posion).getEmpId());
                                setID.setName(resultsBeen.get(posion).getName());
                                callBack.Back(ApprovalerSelectFragment.this);
                            }
                        });
                    }
                });
    }

    public interface SetID {
        void setID(String ID);

        void setName(String name);
    }

    private SetID setID;


    @BindView(R.id.back)
    ImageView back;

    @OnClick(R.id.back)
    void onback() {
        callBack.Back(this);
    }

    @BindView(R.id.main_title)
    RelativeLayout mainTitle;
    @BindView(R.id.search_imag)
    ImageView searchImag;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    @BindView(R.id.search_layout)
    LinearLayout searchLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.quickSideBarTipsView)
    QuickSideBarTipsView quickSideBarTipsView;
    @BindView(R.id.quickSideBarView)
    QuickSideBarView quickSideBarView;
    private FragmentCallBack callBack;

    public ApprovalerSelectFragment() {
    }

    public ApprovalerSelectFragment(SetID setID) {
        // Required empty public constructor
        setIsshownavg(true);
        this.setID = setID;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof FragmentCallBack) {
            this.callBack = (FragmentCallBack) getActivity();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        //callBack.SetVisable(true);
    }

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_approvaler_select, container, false);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final List<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean> list = new ArrayList<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean>();
                if (s.equals(" ")) {
                    showList(resultsBeen);
                    return;
                }
                if (adpater != null) {
                    if (adpater.getResultsBeen() != null) {
                        for (int i = 0; i < adpater.getResultsBeen().size(); i++) {
                            Log.i("TAG", "onTextChanged: " + adpater.getResultsBeen().get(i).getPingyinfirst());
                            if (adpater.getResultsBeen().get(i).getName().toLowerCase().contains(s.toString().toLowerCase()) || StringHelper.getPingYin(adpater.getResultsBeen().get(i).getName()).toLowerCase().contains(s.toString().toLowerCase()) || adpater.getResultsBeen().get(i).getPingyinfirst().toLowerCase().contains(s.toString().toLowerCase())) {
                                list.add(adpater.getResultsBeen().get(i));
                            }
                        }
                        ReviewersAdpater a = new ReviewersAdpater();
                        a.setResultsBeen((ArrayList<QueryReviewersResponse.PayloadBean.ResultsBean.DataListsBean>) list);
                        recyclerView.setAdapter(a);
                        if (headersDecoration == null) {
                            headersDecoration = new StickyRecyclerHeadersDecoration(adpater);
                        } else {
                            headersDecoration.invalidateHeaders();
                        }
                        a.setOnItemClickListener(new ReviewersAdpater.OnItemClickListener() {
                            @Override
                            public void onItemClick(int posion) {
                                setID.setID(list.get(posion).getEmpId());
                                setID.setName(list.get(posion).getName());
                                callBack.Back(ApprovalerSelectFragment.this);
                            }
                        });
/*recyclerView.addItemDecoration(headersDecoration);
                        recyclerView.setl
*/
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        presenter.queryreviewers(1);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private QueryReviewersPresenter presenter;

    @Override
    public void setPresenter(QueryReviewersPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postmesg(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
