package com.mybilibili_tianxuewei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.mybilibili_tianxuewei.base.BaseFragment;

import java.util.ArrayList;

/**
 * 作者：田学伟 on 2017/7/4 18:26
 * QQ：93226539
 * 作用：显示Table的适配器
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<BaseFragment> datas;
    private final String[] titles;

    public HomeViewPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments, String[] titles) {
        super(fm);
        this.datas = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return datas.get(position);
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    //不销毁Viewpager下的item
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
