package com.mybilibili_tianxuewei.common;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * 作者：田学伟 on 2017/7/3 19:33
 * QQ：93226539
 * 作用：
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
