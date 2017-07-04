package com.mybilibili_tianxuewei.fragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mybilibili_tianxuewei.R;
import com.mybilibili_tianxuewei.adapter.HomeViewPagerAdapter;
import com.mybilibili_tianxuewei.base.BaseFragment;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * 作者：田学伟 on 2017/7/4 13:36
 * QQ：93226539
 * 作用：首页
 */

public class HomePageFragment extends BaseFragment {

    @Bind(R.id.title_iv_default_avatar)
    ImageView titleIvDefaultAvatar;
    @Bind(R.id.title_left_menu)
    LinearLayout titleLeftMenu;
    @Bind(R.id.title_iv_game)
    ImageView titleIvGame;
    @Bind(R.id.title_iv_download)
    ImageView titleIvDownload;
    @Bind(R.id.title_iv_right_search)
    ImageView titleIvRightSearch;
    @Bind(R.id.main_title_bar)
    Toolbar mainTitleBar;
    @Bind(R.id.main_title_tablelable)
    TabLayout mainTitleTablelable;
    @Bind(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    @Bind(R.id.main_tab_viewpager)
    ViewPager mainTabViewpager;
    @Bind(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.navigation)
    NavigationView navigation;
    @Bind(R.id.dl_left)
    DrawerLayout dlLeft;
    private String[] titles = {"直播", "推荐", "追播", "分区", "发现"};
    private ArrayList<BaseFragment> fragments;
    private HomeViewPagerAdapter adapter;
    /**
     * 刚才被显示的fragment
     */
    private Fragment tempFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_homepager;
    }

    @Override
    protected void initView() {
        initListener();
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new SinatvActivity());   //直播
        fragments.add(new RecommendActivity());//推荐
        fragments.add(new ReseedingActivity());//追播
        fragments.add(new PartitionActivity());//分区
        fragments.add(new DiscoveryActivity());//发现

    }

    private void initListener() {

    }

    @Override
    protected void initData() {
        adapter = new HomeViewPagerAdapter(getChildFragmentManager(), fragments, titles);
        mainTabViewpager.setAdapter(adapter);
        //关联ViewPager
        mainTitleTablelable.setupWithViewPager(mainTabViewpager);
        mainTitleTablelable.setTabMode(TabLayout.MODE_SCROLLABLE);
        mainTabViewpager.setCurrentItem(1);
    }
}
