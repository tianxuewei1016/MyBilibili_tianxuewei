package com.mybilibili_tianxuewei.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mybilibili_tianxuewei.R;
import com.mybilibili_tianxuewei.adapter.RecommendAdapter;
import com.mybilibili_tianxuewei.base.BaseFragment;
import com.mybilibili_tianxuewei.bean.RecommendBean;
import com.mybilibili_tianxuewei.utils.RetrofiUtils;
import com.mybilibili_tianxuewei.widget.ComprehensiveItemDecoration;

import butterknife.Bind;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 作者：田学伟 on 2017/7/4 18:22
 * QQ：93226539
 * 作用：推荐
 */

public class RecommendActivity extends BaseFragment {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
//    @Bind(R.id.swiperefreshlayout)
//    SwipeRefreshLayout swiperefreshlayout;

    private RecommendAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        getDataFromNet();
    }

    /**
     * 网络请求
     */
    private void getDataFromNet() {
        RetrofiUtils.getRecommendAPI()
                .getRecommendURLInfo()
                .subscribeOn(Schedulers.newThread())//请求在新的线程中执行
                .observeOn(Schedulers.io())         //请求完成后在io线程中执行
                .doOnNext(new Action1<RecommendBean>() {
                    @Override
                    public void call(RecommendBean mediaItem) {
//                        saveUserInfo(userInfo);//保存用户信息到本地
                    }
                }).observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
                .subscribe(new Subscriber<RecommendBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(RecommendBean mediaItem) {
                        setUpAdapter(mediaItem);
                    }
                });

    }

    private void setUpAdapter(RecommendBean mediaItem) {
        adapter = new RecommendAdapter(context,mediaItem.getData());
        recyclerview.setAdapter(adapter);
        //设置布局管理器
        GridLayoutManager manager = new GridLayoutManager(context, 2);
        recyclerview.setLayoutManager(manager);
        recyclerview.addItemDecoration(new ComprehensiveItemDecoration(18));
        //可以设置一条Item所占的列数
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 4) {
                    //按钮隐藏
                    return 2;
                }
                return 1;
            }
        });
    }
}
