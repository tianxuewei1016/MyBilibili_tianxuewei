package com.mybilibili_tianxuewei.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.mybilibili_tianxuewei.R;
import com.mybilibili_tianxuewei.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import rx.Observable;
import rx.functions.Action1;

/**
 * 欢迎界面
 */
public class SplashActivity extends BaseActivity {
    @Bind(R.id.welcome_iv_icon)
    ImageView welcomeIvIcon;
    @Bind(R.id.activity_welcome)
    RelativeLayout activityWelcome;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initTitle() {
    }

    @Override
    protected void initData() {
        Glide.with(this).load(R.drawable.boot_animation_gif).into(welcomeIvIcon);
        Observable.timer(6, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startActivity(MainActivity.class);
                        finish();
                    }
                });
    }

    @Override
    protected void initListener() {
        activityWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterActivity();
            }
        });
    }

    private void enterActivity() {
        Intent intent = new Intent(new Intent(SplashActivity.this, MainActivity.class));
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
        finish();
    }
}
