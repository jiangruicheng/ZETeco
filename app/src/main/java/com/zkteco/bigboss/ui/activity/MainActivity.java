package com.zkteco.bigboss.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zkteco.bigboss.R;
import com.zkteco.bigboss.mvp.BasePresenter;
import com.zkteco.bigboss.mvp.BaseView;
import com.zkteco.bigboss.mvp.presenter.Impl.QueryAttPresenterImpl;
import com.zkteco.bigboss.ui.fragment.BasemainFragment;
import com.zkteco.bigboss.ui.fragment.CheckOnWorkFragment;
import com.zkteco.bigboss.util.FragmentCallBack;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, FragmentCallBack {
    private BottomNavigationBar navigationBar;
    private FragmentManager fragmentManager;
    /*    private ApplyFragment applyFragment;
        private ApplyLeaveFragment applyLeaveFragment;
        private SignCardFragment signCardFragment;
        private LeaveListFragment leaveListFragment;
        private LeaveMesegFragment leaveMesegFragment;*/
    private CheckOnWorkFragment checkOnWorkFragment;

    private void initFragment() {
        checkOnWorkFragment = new CheckOnWorkFragment();
        /*fragmentManager.beginTransaction().add(R.id.layFrame, applyFragment, "").
                add(R.id.layFrame, applyFragment, "applyFragment").
                add(R.id.layFrame, applyLeaveFragment, "applyLeaveFragment").
                add(R.id.layFrame, signCardFragment, "signCardFragment").
                add(R.id.layFrame, leaveListFragment, "leaveListFragment").
                add(R.id.layFrame, leaveMesegFragment, "leaveMesegFragment").
                add(R.id.layFrame, checkOnWorkFragment, "checkOnWorkFragment");*/
    }

    private void initNavigationBar() {
        navigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        navigationBar.setActiveColor(R.color.colorButtonLogin).setBarBackgroundColor(R.color.colorWhite);
        navigationBar.addItem(new BottomNavigationItem(R.drawable.dashuju, "大数据"))
                .addItem(new BottomNavigationItem(R.drawable.dianmian, "店面"))
                .addItem(new BottomNavigationItem(R.drawable.att_unselect, "考勤"))
                .addItem(new BottomNavigationItem(R.drawable.jiankong, "监控"))
                .addItem(new BottomNavigationItem(R.drawable.user, "我的"))
                .setFirstSelectedPosition(2).initialise();
    }

    private List<BasemainFragment> fragmentList = new ArrayList<>();

    private void addFragment(BasemainFragment fragment) {

        fragmentManager.beginTransaction().
                add(R.id.layFrame, fragment, fragment.getTag()).
                commit();
        /*for (int i = 0; i < fragmentList.size(); i++) {
            fragmentManager.beginTransaction().hide(fragmentList.get(i)).commit();
        }*/
        if (fragmentList.size() > 0) {
            fragmentManager.beginTransaction().hide(fragmentList.get(fragmentList.size() - 1)).commit();
        }
        fragmentList.add(fragment);
        SetVisable(fragment.isIsshownavg());
    }

    private void removeFragment(BasemainFragment fragment) {
        /*fragmentManager.beginTransaction().
                remove(fragment).
                commit();*/

        if (fragmentList.size() > 1) {
            fragmentManager.beginTransaction().remove(fragmentList.get(fragmentList.size() - 1)).commit();
            fragmentList.remove(fragmentList.size() - 1);
            fragmentManager.beginTransaction().show(fragmentList.get(fragmentList.size() - 1)).commit();
            SetVisable(fragmentList.get(fragmentList.size() - 1).isIsshownavg());
        } else {
            final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Light_Dialog).setTitle("退出APP").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).create();
            alertDialog.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        navigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        initFragment();
        initNavigationBar();
        /*fragmentManager.beginTransaction().
                add(R.id.layFrame, checkOnWorkFragment, checkOnWorkFragment.getTag()).
                commit();*/
        GoTo(checkOnWorkFragment, new QueryAttPresenterImpl());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void GoTo(BasemainFragment fragment, BasePresenter presenter) {
        addFragment(fragment);
        if (presenter != null && fragment instanceof BaseView) {
            ((BaseView) fragment).setPresenter(presenter);
            presenter.setview((BaseView) fragment);
        }
    }

    @Override
    public void Back(BasemainFragment fragment) {
        removeFragment(fragment);

    }

    @Override
    public void SetVisable(boolean Visable) {
        if (Visable) {
            navigationBar.setVisibility(View.VISIBLE);
        } else {
            navigationBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Back(null);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }
}

