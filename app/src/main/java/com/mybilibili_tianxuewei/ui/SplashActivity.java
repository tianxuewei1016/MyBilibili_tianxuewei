package com.mybilibili_tianxuewei.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.mybilibili_tianxuewei.R;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Action1;

/**
 * 欢迎界面
 */
public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.welcome_iv_icon)
    ImageView welcomeIvIcon;
    @Bind(R.id.activity_welcome)
    RelativeLayout activityWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        Glide.with(this).load(R.drawable.boot_animation_gif).into(welcomeIvIcon);
        Observable.timer(6, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                });
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
