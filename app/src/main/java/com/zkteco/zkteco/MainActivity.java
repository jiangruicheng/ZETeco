package com.zkteco.zkteco;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zkteco.zkteco.Utill.FragmentCallBack;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, FragmentCallBack {
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
        navigationBar.addItem(new BottomNavigationItem(R.drawable.imag_login_80, "大数据"))
                .addItem(new BottomNavigationItem(R.drawable.imag_login_80, "店面"))
                .addItem(new BottomNavigationItem(R.drawable.imag_login_80, "考勤"))
                .addItem(new BottomNavigationItem(R.drawable.imag_login_80, "监控"))
                .addItem(new BottomNavigationItem(R.drawable.imag_login_80, "我的"))
                .setFirstSelectedPosition(2).initialise();
    }

    private void addFragment(Fragment fragment) {
        fragmentManager.beginTransaction().
                replace(R.id.layFrame, fragment, fragment.getTag()).
                addToBackStack(fragment.getTag()).
                commit();
    }

    private void removeFragment(Fragment fragment) {
        /*fragmentManager.beginTransaction().
                remove(fragment).
                commit();*/
        fragmentManager.popBackStack();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        navigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        initFragment();
        initNavigationBar();
        fragmentManager.beginTransaction().
                add(R.id.layFrame, checkOnWorkFragment, checkOnWorkFragment.getTag()).
                commit();
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
    public void GoTo(Fragment fragment) {
        addFragment(fragment);

    }

    @Override
    public void Back(Fragment fragment) {
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

}

